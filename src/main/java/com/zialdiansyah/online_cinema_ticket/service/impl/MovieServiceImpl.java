package com.zialdiansyah.online_cinema_ticket.service.impl;

import com.zialdiansyah.online_cinema_ticket.domain.Genre;
import com.zialdiansyah.online_cinema_ticket.domain.Movie;
import com.zialdiansyah.online_cinema_ticket.dto.MovieDTO;
import com.zialdiansyah.online_cinema_ticket.repository.MovieRepository;
import com.zialdiansyah.online_cinema_ticket.service.MovieService;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<MovieDTO> getNowPlayingMoviesByCity(Integer cityId) {
        LocalDateTime startOfDay = LocalDate.now().atStartOfDay();
        LocalDateTime endOfDay = LocalDate.now().atTime(LocalTime.MAX);

        List<Movie> movies = movieRepository.findNowPlayingMoviesByCity(cityId, startOfDay, endOfDay);
    
        return movies.stream().map(movie -> {
            MovieDTO dto = new MovieDTO();
            dto.setMovieId(movie.getMovieId());
            dto.setTitle(movie.getTitle());
            dto.setDescription(movie.getDescription());
            dto.setDurationMinutes(movie.getDurationMinutes());
            dto.setReleaseDate(movie.getReleaseDate());

            List<String> genreName = movie.getGenres().stream()
                .map(genre -> genre.getName())
                .collect(Collectors.toList());
    
            dto.setGenres(genreName);
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public List<MovieDTO> getComingSoonMovies() {
        List<Movie> movies = movieRepository.findByReleaseDateAfter(LocalDate.now());

        return movies.stream().map(movie -> {
            MovieDTO dto = new MovieDTO();
            dto.setMovieId(movie.getMovieId());
            dto.setTitle(movie.getTitle());
            dto.setReleaseDate(movie.getReleaseDate());
            dto.setGenres(
                movie.getGenres().stream()
                    .map(Genre::getName)
                    .collect(Collectors.toList())
            );
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public MovieDTO getMovieDetailById(Integer movieId) {
        Movie movie = movieRepository.findById(movieId)
            .orElseThrow(() -> new EntityNotFoundException("Movie not found"));

        MovieDTO dto = new MovieDTO();
        dto.setMovieId(movie.getMovieId());
        dto.setTitle(movie.getTitle());
        dto.setDescription(movie.getDescription());
        dto.setDurationMinutes(movie.getDurationMinutes());
        dto.setReleaseDate(movie.getReleaseDate());
        dto.setGenres(
            movie.getGenres().stream()
                .map(Genre::getName)
                .collect(Collectors.toList())
        );
        return dto;
    }

    @Override
    public List<MovieDTO> getMoviesByCinema(Integer cinemaId) {
        List<Movie> movies = movieRepository.findMoviesByCinema(cinemaId);
        return movies.stream().map(movie -> {
            MovieDTO dto = new MovieDTO();
            dto.setMovieId(movie.getMovieId());
            dto.setTitle(movie.getTitle());
            dto.setDescription(movie.getDescription());
            dto.setDurationMinutes(movie.getDurationMinutes());
            dto.setReleaseDate(movie.getReleaseDate());
            dto.setGenres(movie.getGenres().stream()
                .map(g -> g.getName()) // Asumsikan Genre punya method getName()
                .collect(Collectors.toList()));
            return dto;
        }).collect(Collectors.toList());
    }
}
