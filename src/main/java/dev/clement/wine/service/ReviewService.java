package dev.clement.wine.service;

import dev.clement.wine.entity.Price;
import dev.clement.wine.entity.Review;
import dev.clement.wine.exception.WineException;
import dev.clement.wine.model.PriceRequest;
import dev.clement.wine.model.PriceResponse;
import dev.clement.wine.model.ReviewRequest;
import dev.clement.wine.model.ReviewResponse;
import dev.clement.wine.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static dev.clement.wine.exception.ErrorCode.NOT_FOUND;

@Service
public class ReviewService {

    private final static Logger log = LoggerFactory.getLogger(ReviewService.class);

    private final ReviewRepository reviewRepository;
    private final WineRepository wineRepository;
    private final ClientRepository clientRepository;

    public ReviewService(ReviewRepository reviewRepository,
                         WineRepository wineRepository,
                         ClientRepository clientRepository) {
        this.reviewRepository = reviewRepository;
        this.wineRepository = wineRepository;
        this.clientRepository = clientRepository;
    }

    @Transactional
    public ReviewResponse createReview(final ReviewRequest request) {
        var wine = wineRepository.findById(request.idWine()).orElseThrow(() -> new WineException(NOT_FOUND, request.idWine()));
        var client = clientRepository.findById(request.idClient()).orElseThrow(() -> new WineException(NOT_FOUND, request.idClient()));
        var review = new Review(request.rating(), request.comment(), wine, client);
        reviewRepository.save(review);
        return ReviewResponse.from(review);
    }

}
