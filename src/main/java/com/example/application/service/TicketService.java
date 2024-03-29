package com.example.application.service;

import com.example.application.model.Ticket;
import com.example.application.repository.TicketRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.List;

import static com.example.application.util.DateTimeUtil.atStartOfDayOrMin;
import static com.example.application.util.DateTimeUtil.atStartOfNextDayOrMax;
import static com.example.application.util.validation.ValidationUtil.checkNotFoundWithId;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public Ticket get(int id) {
        return ticketRepository.getWithMaterial(id);
    }

    public Ticket getTicketForMaterial(int materialId) {
        return checkNotFoundWithId(ticketRepository.getTicketForMaterial(materialId), materialId);
    }

    public void delete(int id, int userId) {
        checkNotFoundWithId(ticketRepository.delete(id, userId), id);
    }

    public List<Ticket> getAll(int userId) {
        return ticketRepository.getAll(userId);
    }

    public List<Ticket> getAll() {
        return ticketRepository.getAll();
    }

    public void update(Ticket ticket, int userId) {
        Assert.notNull(ticket, "ticket must not be null");
        checkNotFoundWithId(ticketRepository.save(ticket, userId), ticket.id());
    }

    public void updateForAdmin(Ticket ticket) {
        Assert.notNull(ticket, "ticket must not be null");
        checkNotFoundWithId(ticketRepository.saveForAdmin(ticket), ticket.id());
    }

    public Ticket create(Ticket ticket, int userId) {
        Assert.notNull(ticket, "ticket must not be null");
        return ticketRepository.save(ticket, userId);
    }

    public List<Ticket> getBetweenInclusive(@Nullable LocalDate startDate, @Nullable LocalDate endDate, int userId) {
        return ticketRepository.getBetweenHalfOpen(atStartOfDayOrMin(startDate), atStartOfNextDayOrMax(endDate), userId);
    }

    public List<Ticket> deleteForAdmin(@Nullable LocalDate startDate, @Nullable LocalDate endDate) {
        return ticketRepository.getBetweenHalfOpenForAdmin(atStartOfDayOrMin(startDate), atStartOfNextDayOrMax(endDate));
    }
}
