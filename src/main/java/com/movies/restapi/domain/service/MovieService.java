package com.movies.restapi.domain.service;

import com.movies.restapi.domain.model.Movie;
import com.movies.restapi.domain.repository.CreateForm;
import com.movies.restapi.domain.repository.UpdateForm;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;

import java.util.List;
import java.util.Optional;

public interface MovieService {

    @Cacheable(value = "getAllMovies")
    List<Movie> findAll();

    @Cacheable(value = "getById", key = "#p0")
    Optional<Movie> findById(int id);

    @Cacheable(value = "getBySeries", key = "#p0")
    List<Movie> findBySeries(String series);

    @Cacheable(value = "getByPublishedYear", key = "#p0")
    List<Movie> findByPublishedYear(int publishedYear);

    @Cacheable(value = "getByYearAndSeries", key = "#p0")
    List<Movie> findByYearAndSeries(int publishedYear, String series);

    @CacheEvict(value = "getAllMovies", allEntries = true)
    void createMovie(CreateForm form);

    @Caching(evict = {
            @CacheEvict(value = "getAllMovies", allEntries = true),
            @CacheEvict(value = "getById", key = "#p0"),
            @CacheEvict(value = "getByPublishedYear", key = "#p0"),
            @CacheEvict(value = "getBySeries", key = "#p0")
    })
    void updateMovie(int id, UpdateForm form);

    @Caching(evict = {
            @CacheEvict(value = "getAllMovies", allEntries = true),
            @CacheEvict(value = "getById", key = "#p0"),
            @CacheEvict(value = "getByPublishedYear", key = "#p0"),
            @CacheEvict(value = "getBySeries", key = "#p0")
    })
    void deleteMovie(int id);
}
