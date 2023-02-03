package com.movies.restapi.domain.service;

import com.movies.restapi.domain.model.Movie;
import com.movies.restapi.infrastructure.InsertForm;

import java.util.List;
import java.util.Optional;

public interface MovieService {

    List<Movie> findAll();

    Optional<Movie> findById(int id);

    void insertMovie(InsertForm form);
}
