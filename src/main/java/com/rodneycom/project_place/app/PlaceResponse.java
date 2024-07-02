package com.rodneycom.project_place.app;

import java.time.LocalDateTime;

public record PlaceResponse(String name, String slug, String state, LocalDateTime createdAt, LocalDateTime updateAt) {
}
