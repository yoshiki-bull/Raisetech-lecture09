package com.movies.restapi.infrastructure;

import com.movies.restapi.domain.model.Movie;
import com.movies.restapi.application.CreateForm;
import com.movies.restapi.application.UpdateForm;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper
public interface MovieMapper {
    @Select("SELECT * FROM movies")
    List<Movie> findAll();

    @Select("SELECT * FROM movies WHERE id = #{id}")
    Optional<Movie> findById(int id);

    @Select("SELECT * FROM movies WHERE series = #{series}")
    List<Movie> findBySeries(String series);

    @Select("SELECT * FROM movies WHERE published_year = #{publishedYear}")
    List<Movie> findByPublishedYear(int publishedYear);

    @Select("SELECT * FROM movies WHERE published_year = #{publishedYear} AND series = #{series}")
    List<Movie> findByYearAndSeries(int publishedYear, String series);

    @Insert("INSERT INTO movies (name, published_year, series) VALUES (#{name}, #{publishedYear}, #{series})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void createMovie(CreateForm form);

    @Update("UPDATE movies SET name = #{name}, published_year = #{publishedYear}, series = #{series}  WHERE id = #{id}")
    void updateMovie(UpdateForm form);

    @Delete("DELETE FROM movies WHERE id = #{id}")
    void deleteMovie();
}
