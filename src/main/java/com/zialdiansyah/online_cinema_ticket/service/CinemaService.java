package com.zialdiansyah.online_cinema_ticket.service;

import java.util.List;
import com.zialdiansyah.online_cinema_ticket.dto.CinemaDTO;

public interface CinemaService {
    List<CinemaDTO> getCinemasByCity(Integer cityId);
}
