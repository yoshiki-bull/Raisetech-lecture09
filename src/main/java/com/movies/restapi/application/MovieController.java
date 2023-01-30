package com.movies.restapi.application;

import com.movies.restapi.domain.model.Movie;
import com.movies.restapi.domain.service.MovieService;
import com.movies.restapi.infrastructure.MovieMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Movie> getMovies() {
        List<Movie> movies = movieService.findAll();
        return movies;
    }
}
