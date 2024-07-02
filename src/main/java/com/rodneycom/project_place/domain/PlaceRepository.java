package com.rodneycom.project_place.domain;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface PlaceRepository extends ReactiveCrudRepository<Place, Long> {
    Mono<Boolean> existsById(Long id);
}
