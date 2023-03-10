package com.movies.restapi.application;

import lombok.Getter;

@Getter
public class MovieCreateResponse {

    private String message;

    private String name;

    private String publishedYear;

    private String series;

    public MovieCreateResponse(CreateForm form) {
        this.message = "movie successfully created";
        this.name = form.getName();
        this.publishedYear = form.getPublishedYear();
        this.series = form.getSeries();
    }
}
