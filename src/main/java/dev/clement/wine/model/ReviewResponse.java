package dev.clement.wine.model;

import dev.clement.wine.entity.Review;

public record ReviewResponse(Float rating, String comment) {

    public static ReviewResponse from(Review review) {
        return new ReviewResponse(review.getRating(), review.getComment());
    }
}
