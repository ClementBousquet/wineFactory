package dev.clement.wine.model;

import javax.validation.constraints.NotBlank;

public record WineRequest(@NotBlank(message = "Name field is mandatory")
                          String name,
                          String year,
                          Float volume,
                          String color) {
}
