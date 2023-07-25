package dev.clement.wine.model;

import javax.validation.constraints.NotNull;

public record ReviewRequest(@NotNull(message = "idWine field is mandatory")
                            Integer idWine,
                            @NotNull(message = "idClient field is mandatory")
                            Integer idClient,
                            @NotNull(message = "Rating field is mandatory")
                            Float rating,
                            String comment) {
}
