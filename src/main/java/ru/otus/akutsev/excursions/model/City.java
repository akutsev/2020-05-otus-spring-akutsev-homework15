package ru.otus.akutsev.excursions.model;

import javax.persistence.*;

@Entity
@Table(name = "cities")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "is_on_seaside")
    private Boolean isOnSeaside;

    public City() {
    }

    public City(long id, String name, Boolean isOnSeaside) {
        this.id = id;
        this.name = name;
        this.isOnSeaside = isOnSeaside;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getOnSeaside() {
        return isOnSeaside;
    }

    public void setOnSeaside(Boolean onSeaside) {
        isOnSeaside = onSeaside;
    }
}
