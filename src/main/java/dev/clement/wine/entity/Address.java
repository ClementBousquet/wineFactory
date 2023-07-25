package dev.clement.wine.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = Address.TABLE_NAME)
public class Address {

    public static final String TABLE_NAME = "address";

    @Id
    @SequenceGenerator(
            allocationSize = 1,
            name = "ADDRESS_ID_GENERATOR",
            sequenceName = "id_address_seq")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ADDRESS_ID_GENERATOR")
    @Column(name = "id")
    private Integer id;

    @Column(name = "street")
    private String street;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "postalCode")
    private String postalCode;

    @Column(name = "country")
    private String country;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_address")
    @JsonIgnore
    private Producer producer;

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(final String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(final String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(final String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(final String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(final String country) {
        this.country = country;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(final Producer producer) {
        this.producer = producer;
    }

    public Address() {
    }
}
