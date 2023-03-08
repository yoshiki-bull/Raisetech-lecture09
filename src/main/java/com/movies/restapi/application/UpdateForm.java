package com.movies.restapi.application;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class UpdateForm {

    private final String PUBLISHED_YEAR = "^(18[0-9][0-9]|19[0-9][0-9]|20[0-2][0-9])$";

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
        return Map.of("message", "movie successfully updated", "name", name, "published_year", publishedYear, "series", series);
    }
}
