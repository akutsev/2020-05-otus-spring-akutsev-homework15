package ru.otus.akutsev.excursions.model;

import javax.persistence.*;

@Entity
@Table(name = "attractions")
public class Attraction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @Column(name = "is_available_for_children")
    private Boolean isAvailableForChildren;

    public Attraction() {
    }

    public Attraction(long id, String name, City city, Boolean isAvailableForChildren) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.isAvailableForChildren = isAvailableForChildren;
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

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Boolean getAvailableForChildren() {
        return isAvailableForChildren;
    }

    public void setAvailableForChildren(Boolean availableForChildren) {
        isAvailableForChildren = availableForChildren;
    }

    @Override
    public String toString() {
        return "Attraction{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city=" + city.getName() +
                ", isAvailableForChildren=" + isAvailableForChildren +
                '}';
    }
}
