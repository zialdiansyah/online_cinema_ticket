package com.zialdiansyah.online_cinema_ticket.web;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/coming-soon")
    public ResponseEntity<List<MovieDTO>> getComingSoonMovies() {
        return ResponseEntity.ok(movieService.getComingSoonMovies());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDTO> getMovieDetail(@PathVariable Integer id) {
        return ResponseEntity.ok(movieService.getMovieDetailById(id));
    }

    @GetMapping("/cinema/{cinemaId}")
    public List<MovieDTO> getMoviesByCinema(@PathVariable Integer cinemaId) {
        return movieService.getMoviesByCinema(cinemaId);
    }
}
