package com.zialdiansyah.online_cinema_ticket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zialdiansyah.online_cinema_ticket.domain.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
    List<Ticket> findByBookingUserUserId(Integer userId);
}
