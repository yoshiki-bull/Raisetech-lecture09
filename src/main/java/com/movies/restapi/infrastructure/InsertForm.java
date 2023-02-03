package com.movies.restapi.infrastructure;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InsertForm {

    private  int id;

    @NotBlank
    @Length(max = 20)
    private String name;

    @NotBlank
    @Pattern(regexp = "^(18[0-9][0-9]|20[0-2][0-9])$")
    private int publishedYear;

    @NotBlank
    @Length(max = 20)
    private String series;
}
