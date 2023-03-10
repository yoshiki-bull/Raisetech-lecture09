package com.movies.restapi.application;

import com.movies.restapi.domain.exception.MovieNotFoundException;
import com.movies.restapi.domain.model.Movie;
import com.movies.restapi.domain.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) { this.movieService = movieService; }

    @GetMapping("/{id}")
    public Movie getMovie(@PathVariable("id") int id) {
        return movieService.findById(id).orElseThrow(() -> new MovieNotFoundException(id));
    }

    //nullチェックをするためにString型でチェックして、その後DBに登録するために型変換してます。
    @GetMapping("/search/")
    public List<MovieResponse> searchMovies(@RequestParam(value = "published_year", required = false) String publishedYear,
                                            @RequestParam(value = "series", required = false) String series) {
        if (publishedYear != null && series != null) {
            return movieService.findByYearAndSeries(Integer.parseInt(publishedYear), series).stream().map(MovieResponse::new).toList();
        } else if(publishedYear != null) {
            return movieService.findByPublishedYear(Integer.parseInt(publishedYear)).stream().map(MovieResponse::new).toList();
        } else if(series != null) {
            return movieService.findBySeries(series).stream().map(MovieResponse::new).toList();
        } else {
            return movieService.findAll().stream().map(MovieResponse::new).toList();
        }
    }

    @PostMapping
    public ResponseEntity<MovieCreateResponse> create(@RequestBody @Validated CreateForm form, UriComponentsBuilder uriBuilder) {
        movieService.createMovie(form);
        MovieCreateResponse movieCreateResponse = new MovieCreateResponse(form);
        URI uri = uriBuilder.path("/movies/" + form.getId())
                .build()
                .toUri();
        return ResponseEntity.created(uri).body(movieCreateResponse);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<MovieUpdateResponse> update(@PathVariable("id") int id, @RequestBody @Validated UpdateForm form) {
        movieService.updateMovie(id, form);
        MovieUpdateResponse movieUpdateResponse = new MovieUpdateResponse(form);
        return ResponseEntity.ok(movieUpdateResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable("id") int id) {
        movieService.deleteMovie(id);
        return ResponseEntity.noContent().build();
    }
}
