package dev.clement.wine.controller;

import dev.clement.wine.model.*;
import dev.clement.wine.model.search.WineSearchByParams;
import dev.clement.wine.service.SearchWineService;
import dev.clement.wine.service.WineService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@Validated
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class WineController {

    private final WineService wineService;
    private final SearchWineService searchWineService;

    public WineController(WineService wineService,
                          SearchWineService searchWineService) {
        this.wineService = wineService;
        this.searchWineService = searchWineService;
    }

    @ResponseStatus(value = CREATED)
    @PostMapping("/api/v1/wines")
    public ResponseEntity<WineResponse> createWine(@RequestBody @Valid WineRequest request) {
        return ResponseEntity.ok(wineService.createWine(request));
    }

    @ResponseStatus(value = OK)
    @GetMapping("/api/v1/wines/{wine-id}")
    public ResponseEntity<WineResponse> getWine(@PathVariable("wine-id") Integer id) {
        return ResponseEntity.ok(wineService.getWine(id));
    }

    @ResponseStatus(value = OK)
    @GetMapping("/api/v1/wines")
    public ResponseEntity<List<WineResponse>> getAllWines() {
        return ResponseEntity.ok(wineService.getAllWines());
    }

    @ResponseStatus(value = OK)
    @DeleteMapping ("/api/v1/wines/{wine-id}")
    public void deleteWine(@PathVariable("wine-id") @NotBlank Integer id) {
        wineService.deleteWine(id);
    }

    @ResponseStatus(value = OK)
    @PatchMapping ("/api/v1/wines")
    public ResponseEntity<WineResponse> updateWine(@RequestBody @Valid WineUpdateRequest request) {
        return ResponseEntity.ok(wineService.updateWine(request));
    }

    @GetMapping("/api/v1/wines/search")
    public Page<WinesSearchResponse> searchSitesByParams(@Valid @RequestBody WineSearchRequest request,
                                                         @RequestParam(defaultValue = "0", required = false) Integer page,
                                                         @RequestParam(defaultValue = "20", required = false) Integer size) {
        return searchWineService.searchWines(WineSearchByParams.fromRequest(request), PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "id")))
                .map(WinesSearchResponse::fromItem);
    }

    @ResponseStatus(value = OK)
    @GetMapping("/api/v1/wines/prices/average")
    public ResponseEntity<WinesPriceAverageResponse> getAllWinesPricesOrderedByAverageDesc(@Valid @RequestBody WinePriceAverageRequest request) {
        return ResponseEntity.ok(wineService.getAllWinesPricesOrderedByAverageDesc(request));
    }

    @ResponseStatus(value = OK)
    @GetMapping("/api/v1/wines/reviews/average")
    public ResponseEntity<WinesReviewAverageResponse> getAllWinesReviewedOrderedByAverageDesc(@Valid @RequestBody WineReviewAverageRequest request) {
        return ResponseEntity.ok(wineService.getAllWinesReviewedOrderedByAverageDesc(request));
    }

}
