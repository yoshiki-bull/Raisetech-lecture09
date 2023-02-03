package com.movies.restapi.domain.service;

import com.movies.restapi.domain.model.Movie;
import com.movies.restapi.infrastructure.InsertForm;
import com.movies.restapi.infrastructure.MovieMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {
    private MovieMapper movieMapper;

    public MovieServiceImpl(MovieMapper movieMapper) {
        this.movieMapper = movieMapper;
    }

    @Override
    public List<Movie> findAll() {
        return movieMapper.findAll();
    }

    @Override
    public Optional<Movie> findById(int id) {
        return  movieMapper.findById(id);
    }

    @Override
    public void insertMovie(InsertForm form) {
        movieMapper.insertMovie(form);
    }
}
