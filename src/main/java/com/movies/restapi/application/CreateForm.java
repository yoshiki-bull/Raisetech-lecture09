package com.movies.restapi.application;

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
    @Length(max = 100)
    private String name;

    @NotBlank
    @Pattern(regexp = PUBLISHED_YEAR)
    private String publishedYear;

    @NotBlank
    @Length(max = 20)
    private String series;
}
