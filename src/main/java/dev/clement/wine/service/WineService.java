package dev.clement.wine.service;

import dev.clement.wine.entity.Price;
import dev.clement.wine.entity.Review;
import dev.clement.wine.entity.Wine;
import dev.clement.wine.exception.WineException;
import dev.clement.wine.model.*;
import dev.clement.wine.repository.WineRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static dev.clement.wine.exception.ErrorCode.NOT_FOUND;
import static java.util.Objects.nonNull;

@Service
public class WineService {

    private final static Logger log = LoggerFactory.getLogger(WineService.class);

    private final WineRepository wineRepository;

    public WineService(WineRepository wineRepository) {
        this.wineRepository = wineRepository;
    }

    @Transactional
    public WineResponse createWine(final WineRequest request) {
        var wine = new Wine(request.name(), request.year(), request.volume(), request.color());
        wineRepository.save(wine);
        return WineResponse.from(wine);
    }

    public WineResponse getWine(final Integer id) {
        var wine = wineRepository.findById(id).orElseThrow(() -> new WineException(NOT_FOUND, id));
        return WineResponse.from(wine);
    }

    public List<WineResponse> getAllWines() {
        return wineRepository.findAll().stream().map(WineResponse::from).toList();
    }

    public void deleteWine(final Integer id) {
        var wine = wineRepository.findById(id).orElseThrow(() -> new WineException(NOT_FOUND, id));
        wineRepository.delete(wine);
    }

    @Transactional
    public WineResponse updateWine(final WineUpdateRequest request) {
        var wine = wineRepository.findById(request.id()).orElseThrow(() -> new WineException(NOT_FOUND, request.id()));
        wine.setName(request.name());
        wine.setVolume(request.volume());
        wine.setColor(request.color());
        wine.setYear(request.year());
        return WineResponse.from(wine);
    }

    public WinesPriceAverageResponse getAllWinesPricesOrderedByAverageDesc(WinePriceAverageRequest request) {
        List<WinePriceAverageResponse> result = new ArrayList<>();
        wineRepository.findAll().forEach(wine -> {
            var concernedPrices = wine.getPrices().stream().filter(price -> price.getAmount() < request.upperPrice() &&
                    price.getAmount() > request.lowerPrice()).toList();
            var sum = concernedPrices.stream().map(Price::getAmount).mapToDouble(Float::valueOf).sum();
            result.add(WinePriceAverageResponse.from(wine, (float) (sum / concernedPrices.size())));
        });
        result.sort(Comparator.comparing(WinePriceAverageResponse::average));
        return new WinesPriceAverageResponse(result);
    }

    public WinesReviewAverageResponse getAllWinesReviewedOrderedByAverageDesc(WineReviewAverageRequest request) {
        List<WineReviewAverageResponse> result = new ArrayList<>();
        var wines = wineRepository.findWinesWithPricesBetweenLowerAndUpperRange(request.lowerPrice(), request.upperPrice());
        wines.forEach(wine -> {
            var reviews = wine.getReviews();
            var sum = nonNull(reviews) && !reviews.isEmpty() ? wine.getReviews().stream().map(Review::getRating).mapToDouble(Float::valueOf).sum() : 0f;
            result.add(WineReviewAverageResponse.from(wine, (float) (sum / wine.getReviews().size())));
        });
        result.sort(Comparator.comparing(WineReviewAverageResponse::average));
        return new WinesReviewAverageResponse(result);
    }
}
