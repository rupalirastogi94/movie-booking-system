package me.project.movie.service.impl;

import me.project.movie.exception.MovieNotFoundException;
import me.project.movie.model.Movie;
import me.project.movie.model.Screening;
import me.project.movie.repository.MovieRepository;
import me.project.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Primary
public class MovieServiceImpl implements MovieService {
    private MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Movie getMovieById(Long movie_id) {
        return movieRepository.findById(movie_id).orElseThrow(() -> new MovieNotFoundException(movie_id));
    }

    @Override
    public Movie pushMovie(Movie newMovie) {
        return null;
    }

    @Override
    public Movie updateMovie(Movie updatedMovie, Long movie_id) {
        return null;
    }

    @Override
    public List<Screening> getAllScreeningByMovieId(Long movie_id) {
        Movie movie = getMovieById(movie_id);
        return new ArrayList<>(movie.getScreenings());
    }

    @Override
    public void deleteMovie(Long movie_id) {
        movieRepository.deleteById(movie_id);
    }

    @Override
    public List<Screening> getAllScreeningByMovieIdAndDate(Long movie_id, LocalDate date) {
        Movie movie = getMovieById(movie_id);
        return movie.getScreenings().stream().filter(screening -> screening.getDate().equals(date)).collect(Collectors.toList());
    }
}
