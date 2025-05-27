package com.zialdiansyah.online_cinema_ticket.service.impl;

import com.zialdiansyah.online_cinema_ticket.domain.Movie;
import com.zialdiansyah.online_cinema_ticket.dto.MovieDTO;
import com.zialdiansyah.online_cinema_ticket.repository.MovieRepository;
import com.zialdiansyah.online_cinema_ticket.service.MovieService;

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
}
