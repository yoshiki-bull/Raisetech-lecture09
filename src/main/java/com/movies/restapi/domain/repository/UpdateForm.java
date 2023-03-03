package com.movies.restapi.domain.repository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class UpdateForm {

    private int id;
    private String name;
    private String publishedYear;
    private String series;

    public Map<String, String> message() {
        return Map.of("message", "movie successfully updated", "name", name, "published_year", publishedYear, "series", series);
    }
}
