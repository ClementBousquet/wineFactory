package dev.clement.wine.model;

import javax.validation.constraints.NotNull;

public record WineReviewAverageRequest(@NotNull(message = "lowerPrice field is mandatory")
                                       Float lowerPrice,
                                       @NotNull(message = "upperPrice field is mandatory")
                                       Float upperPrice) {
}
