package com.rodneycom.project_place.domain;

import com.github.slugify.Slugify;
import com.rodneycom.project_place.app.PlaceRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.List;

public class PlaceService {
    private PlaceRepository placeRepository;
    private Slugify slg;

    public PlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
        this.slg = Slugify.builder().build();
    }

    public Mono<Place> create(PlaceRequest placeRequest){
        var place = new Place(null,placeRequest.name(),slg.slugify(placeRequest.name()),placeRequest.state(),null,null);
        return placeRepository.save(place);
    }

    public Flux<Place> placeList(){
        return placeRepository.findAll();
    }

    public Mono<Boolean> deletePlace(Long id){
        return placeRepository.existsById(id)
                .flatMap(exists -> {
                    if (exists){
                        return placeRepository.deleteById(id).then(Mono.just(true));
                    }else{
                        return Mono.just(false);
                    }
                });
    }

    public Mono<Place> updatePlace(Long id, Place newPlace){
        return placeRepository.findById(id)
                .flatMap(existingPlace -> {
                    Place updatedPlace = new Place(
                            existingPlace.id(),
                            newPlace.name(),
                            newPlace.slug(),
                            newPlace.state(),
                            existingPlace.createdAt(),
                            LocalDateTime.now()
                    );
                    return placeRepository.save(updatedPlace);
                });
    }
}
