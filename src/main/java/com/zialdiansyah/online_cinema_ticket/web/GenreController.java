package com.zialdiansyah.online_cinema_ticket.web;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.zialdiansyah.online_cinema_ticket.dto.GenreDTO;
import com.zialdiansyah.online_cinema_ticket.service.GenreService;

@RestController
@RequestMapping("/genres")
public class GenreController {

    private final GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping
    public List<GenreDTO> getAllGenres() {
        return genreService.getAllGenres();
    }
}