package com.movies.restapi.infrastructure;

import com.movies.restapi.domain.model.Movie;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface MovieMapper {
    @Select("SELECT * FROM movies")
    List<Movie> findAll();

    @Select("SELECT * FROM movies WHERE id = #{id}")
    Optional<Movie> findById(int id);

    @Select("SELECT * FROM movies WHERE series = #{series}")
    Optional<Movie> findBySeries(String series);

    @Insert("INSERT INTO movies (name, published_year, series) VALUES (#{name}, #{publishedYear}, #{series})")
    void createMovie(CreateForm form);
}
