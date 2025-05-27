package com.zialdiansyah.online_cinema_ticket.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.zialdiansyah.online_cinema_ticket.domain.Cinema;
import com.zialdiansyah.online_cinema_ticket.dto.CinemaDTO;
import com.zialdiansyah.online_cinema_ticket.repository.CinemaRepository;
import com.zialdiansyah.online_cinema_ticket.service.CinemaService;

@Service
public class CinemaServiceImpl implements CinemaService {

    private final CinemaRepository cinemaRepository;

    public CinemaServiceImpl(CinemaRepository cinemaRepository) {
        this.cinemaRepository = cinemaRepository;
    }

    @Override
    public List<CinemaDTO> getCinemasByCity(Integer cityId) {
        List<Cinema> cinemas = cinemaRepository.findByCityCityId(cityId);
        return cinemas.stream()
            .map(cinema -> {
                CinemaDTO dto = new CinemaDTO();
                dto.setCinemaId(cinema.getCinemaId());
                dto.setName(cinema.getName());
                return dto;
            })
            .collect(Collectors.toList());
    }
}
