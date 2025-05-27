package com.zialdiansyah.online_cinema_ticket.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.zialdiansyah.online_cinema_ticket.domain.Ticket;
import com.zialdiansyah.online_cinema_ticket.dto.TicketDTO;
import com.zialdiansyah.online_cinema_ticket.repository.TicketRepository;
import com.zialdiansyah.online_cinema_ticket.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;

    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public List<TicketDTO> getTicketsByUser(Integer userId) {
        List<Ticket> tickets = ticketRepository.findByBookingUserUserId(userId);
        return tickets.stream()
                .map(this::toTicketDTO)
                .collect(Collectors.toList());
    }

    private TicketDTO toTicketDTO(Ticket ticket) {
        TicketDTO dto = new TicketDTO();
        dto.setTicketId(ticket.getTicketId());
        dto.setMovieTitle(ticket.getSchedule().getMovie().getTitle());
        dto.setCinemaName(ticket.getSchedule().getStudio().getCinema().getName());
        dto.setStudioName(ticket.getSchedule().getStudio().getName());
        dto.setStartTime(ticket.getSchedule().getStartTime());
        dto.setPrice(ticket.getSchedule().getPrice());
        dto.setSeatRow(ticket.getSeat().getSeatRow());
        dto.setSeatColumn(ticket.getSeat().getSeatColumn());
        dto.setBookingStatus(ticket.getBooking().getStatus().name());
        return dto;
    }
}
