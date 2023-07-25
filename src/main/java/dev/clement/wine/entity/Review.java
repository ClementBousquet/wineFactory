package dev.clement.wine.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = Review.TABLE_NAME)
public class Review {

    public static final String TABLE_NAME = "review";

    @Id
    @SequenceGenerator(
            allocationSize = 1,
            name = "REVIEW_ID_GENERATOR",
            sequenceName = "id_review_seq")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "REVIEW_ID_GENERATOR")
    @Column(name = "id")
    private Integer id;

    @Column(name = "rating")
    private Float rating;

    @Column(name = "comment")
    private String comment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "fk_id_wine")
    private Wine wine;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "fk_id_user")
    private Client client;

    public Integer getId() {
        return id;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(final Float rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(final String comment) {
        this.comment = comment;
    }

    public Wine getWine() {
        return wine;
    }

    public void setWine(final Wine wine) {
        this.wine = wine;
    }

    public Client getUser() {
        return client;
    }

    public void setUser(final Client client) {
        this.client = client;
    }

    public Review() {
    }

    public Review(final Float rating, final String comment, final Wine wine, final Client client) {
        this.rating = rating;
        this.comment = comment;
        this.wine = wine;
        this.client = client;
    }
}
