package dev.clement.wine.repository;

import dev.clement.wine.entity.Wine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WineRepository extends JpaRepository<Wine, Integer> {

    @Query(value = "SELECT Distinct wi.* FROM wine wi " +
            "LEFT JOIN price pr ON pr.fk_id_wine = wi.id " +
            "WHERE pr.amount BETWEEN :lowerPrice AND :upperPrice ", nativeQuery = true)
    List<Wine> findWinesWithPricesBetweenLowerAndUpperRange(@Param("lowerPrice") Float lowerPrice,
                                                            @Param("upperPrice") Float upperPrice);

}
