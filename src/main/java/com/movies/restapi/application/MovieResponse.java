package com.movies.restapi.application;

import com.movies.restapi.domain.model.Movie;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieResponse {

    private int id;
    private String name;
    private int publishedYear;
    private String series;

    public MovieResponse(Movie movie) {
        this.id = movie.getId();
        this.name = movie.getName();
        this.publishedYear = movie.getPublishedYear();
        this.series = movie.getSeries();
    }
}
