package dev.clement.wine.service;

import dev.clement.wine.entity.Wine;
import dev.clement.wine.exception.WineException;
import dev.clement.wine.model.WineRequest;
import dev.clement.wine.model.WineResponse;
import dev.clement.wine.model.WineUpdateRequest;
import dev.clement.wine.model.search.WineSearchByParams;
import dev.clement.wine.model.search.WineSearchItem;
import dev.clement.wine.repository.SearchWinesRepository;
import dev.clement.wine.repository.WineRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static dev.clement.wine.exception.ErrorCode.NOT_FOUND;

@Service
public class SearchWineService {

    private final static Logger log = LoggerFactory.getLogger(SearchWineService.class);

    private final SearchWinesRepository searchWinesRepository;

    public SearchWineService(SearchWinesRepository searchWinesRepository) {
        this.searchWinesRepository = searchWinesRepository;
    }

    public Page<WineSearchItem> searchWines(WineSearchByParams request, Pageable pageable) {
        return searchWinesRepository.searchWines(request, pageable).map(this::fromWine);
    }

    private WineSearchItem fromWine(Wine wine) {
        return new WineSearchItem(wine.getName(), wine.getYear(), wine.getVolume(), wine.getColor());
    }

}
