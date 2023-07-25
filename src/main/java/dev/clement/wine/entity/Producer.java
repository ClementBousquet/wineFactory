package dev.clement.wine.entity;

import javax.persistence.*;

@Entity
@Table(name = Producer.TABLE_NAME)
public class Producer {

    public static final String TABLE_NAME = "producer";

    @Id
    @SequenceGenerator(
            allocationSize = 1,
            name = "PRODUCER_ID_GENERATOR",
            sequenceName = "id_producer_seq")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "PRODUCER_ID_GENERATOR")
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToOne(mappedBy = "producer")
    @JoinColumn(name = "fk_id_address")
    private Address address;

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

    public Address getAddress() {
        return address;
    }

    public void setAddress(final Address address) {
        this.address = address;
    }

    public Producer() {
    }
}
