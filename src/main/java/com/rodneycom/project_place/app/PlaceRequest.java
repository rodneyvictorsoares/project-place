package com.rodneycom.project_place.app;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record PlaceRequest(@NotBlank String name, @NotBlank String state) {
}
