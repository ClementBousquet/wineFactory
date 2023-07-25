package dev.clement.wine.repository;

import dev.clement.wine.entity.Wine;
import org.springframework.data.jpa.domain.Specification;


public class WineSearchSpecifications {
    private WineSearchSpecifications() {
    }

    public static Specification<Wine> wineNameLike(String wineName) {
        return (root, query, builder) -> builder.like(builder.lower(root.get("name")), wineName.toLowerCase() + "%");
    }

    public static Specification<Wine> yearEqualsTo(String year) {
        return (root, query, builder) -> builder.equal(root.get("year"), year);
    }

    public static Specification<Wine> volumeEqualsTo(Float volume) {
        return (root, query, builder) -> builder.equal(root.get("volume"), volume);
    }

    public static Specification<Wine> colorEqualsTo(String color) {
        return (root, query, builder) -> builder.equal(root.get("color"), color);
    }
}
