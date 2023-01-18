package com.example.Application.repository;

import com.example.Application.core.Ticket;

import java.util.List;

public interface TicketRepository {

    Ticket save(Ticket ticket);

    boolean delete(int id);

    Ticket get(int id);

    List<Ticket> getAll();
}
