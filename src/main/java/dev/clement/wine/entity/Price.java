package dev.clement.wine.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = Price.TABLE_NAME)
public class Price {

    public static final String TABLE_NAME = "price";

    @Id
    @SequenceGenerator(
            allocationSize = 1,
            name = "PRICE_ID_GENERATOR",
            sequenceName = "id_price_seq")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "PRICE_ID_GENERATOR")
    @Column(name = "id")
    private Integer id;

    @Column(name = "amount")
    private float amount;

    @Column(name = "date")
    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "fk_id_wine")
    private Wine wine;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "fk_id_site")
    private Site site;

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(final float amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(final LocalDate date) {
        this.date = date;
    }

    public Wine getWine() {
        return wine;
    }

    public void setWine(final Wine wine) {
        this.wine = wine;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(final Site site) {
        this.site = site;
    }

    public Price() {
    }

    public Price(final float amount, final LocalDate date, final Wine wine, final Site site) {
        this.amount = amount;
        this.date = date;
        this.wine = wine;
        this.site = site;
    }
}
