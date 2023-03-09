package com.movies.restapi;

import com.movies.restapi.application.MovieController;
import com.movies.restapi.domain.service.MovieService;
import com.movies.restapi.infrastructure.MovieMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class RestapiApplicationTests {

	@Autowired
	private MovieController movieController;

	@Autowired
	private MovieService movieService;

	@Autowired
	private MovieMapper movieMapper;

	// テストの詳細をコメントで記述する。
	// アプリケーションがSpringコンテキストを正常にロードできたかを検証する。
	@Test
	void contextLoads() {
		// assertThatを利用した検証を実装する。
		// assertThatの引数に検証したい値を入れる。
		// 続けてメソッドにて期待値を指定する。この場合はNullでないこと。
		assertThat(movieController).isNotNull();
		assertThat(movieService).isNotNull();
		assertThat(movieMapper).isNotNull();
	}

}
