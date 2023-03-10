package com.movies.restapi.domain.exception;

public class MovieNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public MovieNotFoundException(int id) {
        super("映画ID：" + id + "は見つかりません。");
    }
}
