package com.example.application.repository;

import com.example.application.model.Material;
import com.example.application.model.Ticket;

import java.time.LocalDateTime;
import java.util.List;

public interface TicketRepository {

    Ticket save(Ticket ticket, int userId);

    boolean delete(int id, int userId);
    boolean deleteForAdmin(int id);

    Ticket get(int id, int userId);

    List<Ticket> getAll(int userId);

    List<Ticket> getAll();

    Ticket getWithMaterial(int id, int userId);

    List<Ticket> getBetweenHalfOpen(LocalDateTime startDateTime, LocalDateTime endDateTime, int userId);

    List<Ticket> getBetweenHalfOpenForAdmin(LocalDateTime atStartOfDayOrMin, LocalDateTime atStartOfNextDayOrMax);
}
