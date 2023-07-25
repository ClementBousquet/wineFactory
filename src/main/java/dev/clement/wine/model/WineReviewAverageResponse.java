package dev.clement.wine.model;

import dev.clement.wine.entity.Wine;

public record WineReviewAverageResponse(String name, String year, Float average) {

    public static WineReviewAverageResponse from(Wine wine, Float average) {
        return new WineReviewAverageResponse(wine.getName(), wine.getYear(), average);
    }
}
