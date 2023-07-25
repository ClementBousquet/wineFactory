package dev.clement.wine.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = Wine.TABLE_NAME)
public class Wine {

    public static final String TABLE_NAME = "wine";

    @Id
    @SequenceGenerator(
            allocationSize = 1,
            name = "WINE_ID_GENERATOR",
            sequenceName = "id_wine_seq")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "WINE_ID_GENERATOR")
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "year")
    private String year;

    @Column(name = "volume")
    private Float volume;

    @Column(name = "color")
    private String color;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "wine")
    @JsonIgnore
    private List<Price> prices;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "wine")
    @JsonIgnore
    private List<Review> reviews;

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(final String year) {
        this.year = year;
    }

    public Float getVolume() {
        return volume;
    }

    public void setVolume(final Float volume) {
        this.volume = volume;
    }

    public String getColor() {
        return color;
    }

    public void setColor(final String color) {
        this.color = color;
    }

    public List<Price> getPrices() {
        return prices;
    }

    public void setPrices(final List<Price> prices) {
        this.prices = prices;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(final List<Review> reviews) {
        this.reviews = reviews;
    }

    public Wine() {
    }

    public Wine(final String name, final String year, final Float volume, final String color) {
        this.name = name;
        this.year = year;
        this.volume = volume;
        this.color = color;
    }

    public Wine(final String name, final String year, final Float volume, final String color, final List<Price> prices, final List<Review> reviews) {
        this.name = name;
        this.year = year;
        this.volume = volume;
        this.color = color;
        this.prices = prices;
        this.reviews = reviews;
    }
}
