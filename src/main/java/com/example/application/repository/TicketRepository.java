package com.example.application.repository;

import com.example.application.model.Material;
import com.example.application.model.Ticket;

import java.time.LocalDateTime;
import java.util.List;

public interface TicketRepository {

    Ticket save(Ticket ticket, int userId);

    boolean delete(int id, int userId);

    Ticket get(int id, int userId);

    List<Ticket> getAll(int userId);

    Ticket getWithMaterial(int id, int userId, List<Material> materialList);

    List<Ticket> getBetweenHalfOpen(LocalDateTime startDateTime, LocalDateTime endDateTime, int userId);
}
