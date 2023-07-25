package dev.clement.wine.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public record WineUpdateRequest(@NotNull(message = "Id field is mandatory") Integer id,
                                @NotBlank(message = "Name field is mandatory")
                                String name,
                                String year,
                                Float volume,
                                String color) {
}
