package com.example.application.repository;

import com.example.application.model.Material;
import com.example.application.model.Ticket;

import java.time.LocalDateTime;
import java.util.List;

public interface TicketRepository {

    Ticket save(Ticket ticket, int userId);

    Ticket saveForAdmin(Ticket ticket);

    boolean delete(int id, int userId);

    boolean deleteForAdmin(int id);

    Ticket get(int id);

    Ticket getTicketForMaterial(int materialId);

    List<Ticket> getAll(int userId);

    List<Ticket> getAll();

    Ticket getWithMaterial(int id);

    List<Ticket> getBetweenHalfOpen(LocalDateTime startDateTime, LocalDateTime endDateTime, int userId);

    List<Ticket> getBetweenHalfOpenForAdmin(LocalDateTime atStartOfDayOrMin, LocalDateTime atStartOfNextDayOrMax);
}
