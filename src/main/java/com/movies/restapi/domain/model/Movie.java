package com.movies.restapi.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
}
