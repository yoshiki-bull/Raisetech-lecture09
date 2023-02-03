package com.movies.restapi.application;

import com.movies.restapi.domain.model.Movie;
import com.movies.restapi.domain.service.MovieService;
import com.movies.restapi.infrastructure.InsertForm;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;
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

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Map<String, String>> insert(@RequestBody @Validated InsertForm form, UriComponentsBuilder uriComponentsBuilder) {
        movieService.insertMovie(form);
        String name = form.getName();
        int publishedYear = form.getPublishedYear();
        String series = form.getSeries();
        Map<String, String> message = Map.of("name", name,  "published-year", Integer.toString(publishedYear), "series", series);
        URI uri = uriComponentsBuilder.path("/movies" + form.getId())
                .build()
                .toUri();
        return ResponseEntity.created(uri).body(message);
    }
}
