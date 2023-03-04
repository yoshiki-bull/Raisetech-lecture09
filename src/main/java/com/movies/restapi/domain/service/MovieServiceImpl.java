package com.movies.restapi.domain.service;

import com.movies.restapi.domain.model.Movie;
import com.movies.restapi.domain.repository.CreateForm;
import com.movies.restapi.infrastructure.MovieMapper;
import com.movies.restapi.domain.repository.UpdateForm;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {
    private final MovieMapper movieMapper;

    public MovieServiceImpl(MovieMapper movieMapper) { this.movieMapper = movieMapper; }

    @Override
    public List<Movie> findAll() { return movieMapper.findAll(); }

    @Override
    public Optional<Movie> findById(int id) { return movieMapper.findById(id); }

    @Override
    public void createMovie(CreateForm form) { movieMapper.createMovie(form); }

    @Override
    public void updateMovie(int id, UpdateForm form) { movieMapper.updateMovie(form); }

    @Override
    public void deleteMovie(int id) {
        movieMapper.deleteMovie();
    }
}
