package com.movies.restapi.infrastructure;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.hibernate.validator.constraints.Length;

import lombok.Getter;

import java.util.Map;

@Getter
@AllArgsConstructor
public class CreateForm {

    private static final String PUBLISHED_YEAR = "^(18[0-9][0-9]|19[0-9][0-9]|20[0-2][0-9])$";

    private int id;

    @NotBlank
    @Length(max = 20)
    private String name;

    @NotBlank
    @Pattern(regexp = PUBLISHED_YEAR)
    private String publishedYear;

    @NotBlank
    @Length(max = 20)
    private String series;

    public Map<String, String> message() {
        this.name = name;
        this.publishedYear = publishedYear;
        this.series = series;
        return Map.of("message", "movie successfully created", "name", name, "published-year", publishedYear, "series", series);
    }
}
