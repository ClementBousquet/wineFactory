package dev.clement.wine.model;

import dev.clement.wine.model.search.WineSearchItem;

public record WinesSearchResponse(String name,
                                  String year,
                                  Float volume,
                                  String color) {


    public static WinesSearchResponse fromItem(WineSearchItem item) {
        return new WinesSearchResponse(item.name(), item.year(), item.volume(), item.color());
    }

}
