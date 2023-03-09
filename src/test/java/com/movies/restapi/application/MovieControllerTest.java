package com.movies.restapi.application;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.movies.restapi.domain.model.Movie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class MovieControllerTest {

    @Autowired
    private MockMvc mvc;

    // 検索結果が想定通りであるかを確認するテスト。
    @Test
    void getMovie() throws Exception {
        int id = 1;
        String responseJsonString = mvc.perform(get("/movies/{id}", id)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()) //ステータスコードチェック。
                .andReturn().getResponse().getContentAsString();

        // 取得したオブジェクトをJavaオブジェクトにマッピング
        ObjectMapper objectMapper = new ObjectMapper();
        Movie responseMovie = objectMapper.readValue(responseJsonString, Movie.class);

        // 各値を比較する
        assertThat(responseMovie.getId()).isEqualTo(1);
        assertThat(responseMovie.getName()).isEqualTo("Iron Man");
        assertThat(responseMovie.getPublishedYear()).isEqualTo("2008");
        assertThat(responseMovie.getSeries()).isEqualTo("Iron Man");
    }
}