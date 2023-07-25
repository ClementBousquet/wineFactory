package dev.clement.wine.controller;

import dev.clement.wine.model.*;
import dev.clement.wine.model.search.WineSearchByParams;
import dev.clement.wine.service.PriceService;
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
public class PriceController {

    private final PriceService priceService;

    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @ResponseStatus(value = CREATED)
    @PostMapping("/api/v1/prices")
    public ResponseEntity<PriceResponse> createPrice(@RequestBody @Valid PriceRequest request) {
        return ResponseEntity.ok(priceService.createPrice(request));
    }

}
