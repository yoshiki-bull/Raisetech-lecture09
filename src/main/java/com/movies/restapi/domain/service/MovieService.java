package com.movies.restapi.domain.service;

import com.movies.restapi.domain.model.Movie;
import com.movies.restapi.domain.repository.CreateForm;
import com.movies.restapi.domain.repository.UpdateForm;

import java.util.List;
import java.util.Optional;

public interface MovieService {

    List<Movie> findAll();

    Optional<Movie> findById(int id);

    Optional<Movie> findBySeries(String series);

    void createMovie(CreateForm form);

    void updateMovie(int id, UpdateForm form);
}
