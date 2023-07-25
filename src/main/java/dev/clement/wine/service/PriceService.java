package dev.clement.wine.service;

import dev.clement.wine.entity.Price;
import dev.clement.wine.exception.WineException;
import dev.clement.wine.model.PriceRequest;
import dev.clement.wine.model.PriceResponse;
import dev.clement.wine.repository.PriceRepository;
import dev.clement.wine.repository.SiteRepository;
import dev.clement.wine.repository.WineRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static dev.clement.wine.exception.ErrorCode.NOT_FOUND;

@Service
public class PriceService {

    private final static Logger log = LoggerFactory.getLogger(PriceService.class);

    private final PriceRepository priceRepository;
    private final WineRepository wineRepository;
    private final SiteRepository siteRepository;

    public PriceService(PriceRepository priceRepository,
                        WineRepository wineRepository,
                        SiteRepository siteRepository) {
        this.priceRepository = priceRepository;
        this.wineRepository = wineRepository;
        this.siteRepository = siteRepository;
    }

    @Transactional
    public PriceResponse createPrice(final PriceRequest request) {
        var wine = wineRepository.findById(request.idWine()).orElseThrow(() -> new WineException(NOT_FOUND, request.idWine()));
        var site = siteRepository.findById(request.idSite()).orElseThrow(() -> new WineException(NOT_FOUND, request.idSite()));
        var price = new Price(request.amount(), request.date(), wine, site);
        priceRepository.save(price);
        return PriceResponse.from(price);
    }

}
