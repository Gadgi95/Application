package com.example.Application.repository;

import com.example.Application.core.Material;
import com.example.Application.core.Ticket;

import java.util.List;

public interface TicketRepository {

    Ticket save(Ticket ticket);

    boolean delete(int id, int userId);

    Ticket get(int id, int userId);

    List<Ticket> getAll(int userId);

    Ticket getWithMaterial(int id, int userId, List<Material> materialList);
}
