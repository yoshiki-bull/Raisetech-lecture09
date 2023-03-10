package com.movies.restapi.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Movie {

    private int id;
    private String name;
    private int publishedYear;
    private String series;
}
