package com.example.Application.repository.datajpa;

import com.example.Application.core.Ticket;
import com.example.Application.repository.TicketRepository;

import java.util.List;

public class DataJpaTicketRepository implements TicketRepository {
    @Override
    public Ticket save(Ticket ticket) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Ticket get(int id) {
        return null;
    }

    @Override
    public List<Ticket> getAll() {
        return null;
    }
}
