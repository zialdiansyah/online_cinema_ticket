package com.zialdiansyah.online_cinema_ticket.web;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.zialdiansyah.online_cinema_ticket.dto.TicketDTO;
import com.zialdiansyah.online_cinema_ticket.service.TicketService;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/user/{userId}")
    public List<TicketDTO> getTicketsByUser(@PathVariable Integer userId) {
        return ticketService.getTicketsByUser(userId);
    }
}