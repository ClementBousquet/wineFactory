package dev.clement.wine.model.search;

import dev.clement.wine.model.WineSearchRequest;

public record WineSearchByParams(String name, String year, Float volume, String color) {
    public static WineSearchByParams fromRequest(WineSearchRequest request) {
        return new WineSearchByParams(request.name(),
                request.year(),
                request.volume(),
                request.color());
    }
}
