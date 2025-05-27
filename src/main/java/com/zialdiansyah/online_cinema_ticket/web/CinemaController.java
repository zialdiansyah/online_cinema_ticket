package com.zialdiansyah.online_cinema_ticket.web;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.zialdiansyah.online_cinema_ticket.dto.CinemaDTO;
import com.zialdiansyah.online_cinema_ticket.service.CinemaService;

@RestController
@RequestMapping("/cinemas")
public class CinemaController {

    private final CinemaService cinemaService;

    public CinemaController(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    @GetMapping("/city/{cityId}")
    public List<CinemaDTO> getCinemasByCity(@PathVariable Integer cityId) {
        return cinemaService.getCinemasByCity(cityId);
    }
}
