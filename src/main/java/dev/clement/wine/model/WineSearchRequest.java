package dev.clement.wine.model;

public record WineSearchRequest(
        String name,
        String year,
        Float volume,
        String color) {
}
