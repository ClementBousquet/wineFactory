package dev.clement.wine.model;

import dev.clement.wine.entity.Wine;

public record WinePriceAverageResponse(String name, String year, Float average) {

    public static WinePriceAverageResponse from(Wine wine, Float average) {
        return new WinePriceAverageResponse(wine.getName(), wine.getYear(), average);
    }
}
