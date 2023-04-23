package me.project.movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BookMyMovieApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookMyMovieApplication.class, args);
	}

}
