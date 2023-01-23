package com.example.Application.service;

import com.example.Application.core.Ticket;
import com.example.Application.repository.TicketRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

import static com.example.Application.util.validation.ValidationUtil.checkNotFoundWithId;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public Ticket get(int id, int userId) {
        return checkNotFoundWithId(ticketRepository.get(id, userId), id);
    }

    public void delete(int id, int userId) {
        checkNotFoundWithId(ticketRepository.delete(id, userId), id);
    }

    public List<Ticket> getAll(int userId) {
        return ticketRepository.getAll(userId);
    }

    public void update(Ticket ticket) {
        Assert.notNull(ticket, "meal must not be null");
        checkNotFoundWithId(ticketRepository.save(ticket), ticket.id());
    }

    public Ticket create(Ticket ticket) {
        Assert.notNull(ticket, "meal must not be null");
        return ticketRepository.save(ticket);
    }
}
