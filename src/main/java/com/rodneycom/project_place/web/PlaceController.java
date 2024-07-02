package com.rodneycom.project_place.web;

import com.rodneycom.project_place.app.PlaceRequest;
import com.rodneycom.project_place.app.PlaceResponse;
import com.rodneycom.project_place.domain.Place;
import com.rodneycom.project_place.domain.PlaceService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/places")
public class PlaceController {
    private PlaceService placeService;

    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @GetMapping
    public Flux<Place> getPlaces(){
        return placeService.placeList();
    }
    @PostMapping
    public ResponseEntity<Mono<PlaceResponse>> create(@Valid @RequestBody PlaceRequest request){
        var placeResponse = placeService.create(request).map(PlaceMapper::toResponse);
        return ResponseEntity.status(HttpStatus.CREATED).body(placeResponse);
    }
    @PutMapping("/{id}")
    public Mono<ResponseEntity<PlaceResponse>> updatePlaces(@PathVariable Long id, @RequestBody PlaceRequest placeRequest){
        return placeService.updatePlace(id, PlaceMapper.toEntity(placeRequest))
                .map(place -> ResponseEntity.ok(PlaceMapper.toResponse(place)))
                .defaultIfEmpty(ResponseEntity.notFound().build());

    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> deletePlaces(@PathVariable Long id){
        return placeService.deletePlace(id)
                .map(exists -> exists ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build());
    }
}
