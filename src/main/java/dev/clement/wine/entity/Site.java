package dev.clement.wine.entity;

import javax.persistence.*;

@Entity
@Table(name = Site.TABLE_NAME)
public class Site {

    public static final String TABLE_NAME = "site";

    @Id
    @SequenceGenerator(
            allocationSize = 1,
            name = "SITE_ID_GENERATOR",
            sequenceName = "id_site_seq")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SITE_ID_GENERATOR")
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "url")
    private String url;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(final String url) {
        this.url = url;
    }

    public Site() {
    }

    public Site(final String name, final String url) {
        this.name = name;
        this.url = url;
    }
}
