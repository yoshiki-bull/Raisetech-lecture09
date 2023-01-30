package com.movies.restapi.infrastructure;

import com.movies.restapi.domain.model.Movie;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MovieMapper {
    @Select("select * from movies")
    List<Movie> findAll();
}
