package ru.otus.akutsev.excursions.model;

import java.util.List;

public class Excursion {

    private long id;
    private List<Attraction> attractions;

    public Excursion(List<Attraction> attractions) {
        this.attractions = attractions;
    }

    public long getId() {
        return id;
    }

    public List<Attraction> getAttractions() {
        return attractions;
    }

    public void setAttractions(List<Attraction> attractions) {
        this.attractions = attractions;
    }
}
