package dev.clement.wine.controller;

import dev.clement.wine.model.PriceRequest;
import dev.clement.wine.model.PriceResponse;
import dev.clement.wine.model.ReviewRequest;
import dev.clement.wine.model.ReviewResponse;
import dev.clement.wine.service.PriceService;
import dev.clement.wine.service.ReviewService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@Validated
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @ResponseStatus(value = CREATED)
    @PostMapping("/api/v1/reviews")
    public ResponseEntity<ReviewResponse> createReview(@RequestBody @Valid ReviewRequest request) {
        return ResponseEntity.ok(reviewService.createReview(request));
    }

}
