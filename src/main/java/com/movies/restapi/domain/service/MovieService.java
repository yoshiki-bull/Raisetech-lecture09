package com.movies.restapi.domain.service;

import com.movies.restapi.domain.model.Movie;

import java.util.List;

public interface MovieService {

    List<Movie> findAll();
}
