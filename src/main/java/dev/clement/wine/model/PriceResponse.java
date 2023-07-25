package dev.clement.wine.model;

import dev.clement.wine.entity.Price;

import java.time.LocalDate;

public record PriceResponse(Float amount, LocalDate date) {

    public static PriceResponse from(Price price) {
        return new PriceResponse(price.getAmount(), price.getDate());
    }
}
