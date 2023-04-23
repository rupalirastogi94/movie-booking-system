package me.project.movie.exception;

public class MovieNotFoundException extends RuntimeException {
    public MovieNotFoundException(Long movie_id) {
    }
}
