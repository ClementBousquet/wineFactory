package dev.clement.wine.repository;

import dev.clement.wine.entity.Wine;
import dev.clement.wine.model.search.WineSearchByParams;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.stream.DoubleStream;

import static dev.clement.wine.repository.WineSearchSpecifications.*;

@Repository
public interface SearchWinesRepository extends JpaRepository<Wine, Integer>, JpaSpecificationExecutor<Wine> {

    default Page<Wine> searchWines(WineSearchByParams params, Pageable pageable) {
        var specifications = Specification
                .where(params.name() != null ? wineNameLike(params.name()) : null)
                .and(params.year() != null ? yearEqualsTo(params.year()) : null)
                .and(params.volume() != null ? volumeEqualsTo(params.volume()) : null)
                .and(params.color() != null ? colorEqualsTo(params.color()) : null);
        return findAll(specifications, pageable);
    }
}
