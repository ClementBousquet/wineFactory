package dev.clement.wine.model;

import dev.clement.wine.entity.Wine;

public record WineResponse(String name, String year, Float volume, String color) {

    public static WineResponse from(Wine wine) {
        return new WineResponse(wine.getName(), wine.getYear(), wine.getVolume(), wine.getColor());
    }
}
