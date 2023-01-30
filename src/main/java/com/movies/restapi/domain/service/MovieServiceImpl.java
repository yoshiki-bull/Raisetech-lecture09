package com.movies.restapi.domain.service;

import com.movies.restapi.domain.model.Movie;
import com.movies.restapi.infrastructure.MovieMapper;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
