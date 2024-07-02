package com.rodneycom.project_place.web;

import com.rodneycom.project_place.app.PlaceRequest;
import com.rodneycom.project_place.app.PlaceResponse;
import com.rodneycom.project_place.domain.Place;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PlaceMapper {

    public static Place toEntity(PlaceRequest placeRequest) {
        return new Place(
                null,
                placeRequest.name(),
                generateSlug(placeRequest.name()) ,
                placeRequest.state(),
                null,
                null
        );
    }

    public static PlaceResponse toResponse(Place place) {
        return new PlaceResponse(
                place.name(),
                place.slug(),
                place.state(),
                place.createdAt(),
                place.updateAt()
        );
    }

//    public List<PlaceResponse> toResponseList(List<Place> places) {
//        return places.stream()
//                .map(this::toResponse)
//                .collect(Collectors.toList());
//    }
//    public static PlaceResponse fromPlaceToResponse(Place place){
//        return new PlaceResponse(place.name(), place.slug(), place.state(), place.createdAt(),place.updateAt());
//    }

    private static String generateSlug(String name) {
        return name.toLowerCase().replace(" ", "-");
    }
}
