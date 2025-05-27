package com.zialdiansyah.online_cinema_ticket.service;

import com.zialdiansyah.online_cinema_ticket.dto.MovieDTO;

import java.util.List;

public interface MovieService {
    List<MovieDTO> getNowPlayingMoviesByCity(Integer cityId);
    List<MovieDTO> getComingSoonMovies();
    MovieDTO getMovieDetailById(Integer movieId);
}
