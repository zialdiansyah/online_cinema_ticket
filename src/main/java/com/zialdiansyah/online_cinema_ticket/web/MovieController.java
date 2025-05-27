package com.zialdiansyah.online_cinema_ticket.web;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zialdiansyah.online_cinema_ticket.service.MovieService;
import com.zialdiansyah.online_cinema_ticket.dto.MovieDTO;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/now-showing")
    public ResponseEntity<List<MovieDTO>> getNowShowingMovies(@RequestParam Integer cityId) {
        List<MovieDTO> movies = movieService.getNowPlayingMoviesByCity(cityId);
        return ResponseEntity.ok(movies);
    }
}
