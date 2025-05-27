package com.zialdiansyah.online_cinema_ticket.service;

import java.util.List;

import com.zialdiansyah.online_cinema_ticket.dto.TicketDTO;

public interface TicketService {
    List<TicketDTO> getTicketsByUser(Integer userId);
}