package com.movies.restapi.domain.model;

public class Movie {

    private int id;
    private String name;
    private int publishedYear;
    private String series;

    public Movie(int id, String name, int publishedYear, String series) {
        this.id = id;
        this.name = name;
        this.publishedYear = publishedYear;
        this.series = series;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public String getSeries() {
        return series;
    }
}
