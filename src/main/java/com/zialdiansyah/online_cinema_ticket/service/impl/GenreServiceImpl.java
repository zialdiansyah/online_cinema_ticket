package com.zialdiansyah.online_cinema_ticket.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.zialdiansyah.online_cinema_ticket.dto.GenreDTO;
import com.zialdiansyah.online_cinema_ticket.repository.GenreRepository;
import com.zialdiansyah.online_cinema_ticket.service.GenreService;

@Service
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;

    public GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public List<GenreDTO> getAllGenres() {
        return genreRepository.findAll().stream().map(genre -> {
            GenreDTO dto = new GenreDTO();
            dto.setGenreId(genre.getGenreId());
            dto.setName(genre.getName());
            return dto;
        }).collect(Collectors.toList());
    }
}
