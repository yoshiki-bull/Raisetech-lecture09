package com.movies.restapi.application;

import com.movies.restapi.domain.model.Movie;
import com.movies.restapi.domain.repository.UpdateForm;
import com.movies.restapi.domain.service.MovieService;
import com.movies.restapi.domain.repository.CreateForm;
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

    public MovieController(MovieService movieService) { this.movieService = movieService; }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Movie> getMovies() { return movieService.findAll(); }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Movie> getMovie(@PathVariable("id") int id) { return movieService.findById(id); }

    @GetMapping("/series")
    public Optional<Movie> getSeries(@RequestParam(value = "series") String series) {
        return movieService.findBySeries(series);
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> create(@RequestBody @Validated CreateForm form, UriComponentsBuilder uriBuilder) {
        movieService.createMovie(form);
        URI uri = uriBuilder.path("/movies/" + form.getId())
                .build()
                .toUri();
        return ResponseEntity.created(uri).body(form.message());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Map<String, String>> update(@PathVariable("id") int id, @RequestBody UpdateForm form) {
        movieService.updateMovie(id, form);
        return ResponseEntity.ok(form.message());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable("id") int id) {
        movieService.deleteMovie(id);
        return ResponseEntity.noContent().build();
    }
}
