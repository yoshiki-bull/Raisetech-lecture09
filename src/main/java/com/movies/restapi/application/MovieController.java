package com.movies.restapi.application;

import com.movies.restapi.domain.model.Movie;
import com.movies.restapi.domain.service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Movie> getMovies() {
        return movieService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Movie> getMovie(@PathVariable("id") int id) {
        return movieService.findById(id);
    }

    @RequestMapping(value = "/{series}", method = RequestMethod.GET)
    public Optional<Movie> getSeries(@PathVariable("series") String series) {
        return movieService.findBySeries(series);
    }
}
