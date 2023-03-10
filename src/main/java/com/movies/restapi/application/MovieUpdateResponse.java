package com.movies.restapi.application;

import lombok.Getter;

@Getter
public class MovieUpdateResponse {

    private String message;

    private String name;

    private String publishedYear;

    private String series;

    public MovieUpdateResponse(UpdateForm form) {
        this.message = "movie successfully updated";
        this.name = form.getName();
        this.publishedYear = form.getPublishedYear();
        this.series = form.getSeries();
    }
}
