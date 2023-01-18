package com.example.Application.repository.datajpa;

import com.example.Application.core.Material;
import com.example.Application.core.Ticket;
import com.example.Application.repository.TicketRepository;

import java.util.List;

public class DataJpaTicketRepository implements TicketRepository {

    @Override
    public Ticket save(Ticket ticket, int userId) {
        return null;
    }

    @Override
    public boolean delete(int id, int userId) {
        return false;
    }

    @Override
    public Ticket get(int id, int userId) {
        return null;
    }

    @Override
    public List<Ticket> getAll(int userId) {
        return null;
    }

    @Override
    public Ticket getWithMaterial(int id, int userId, List<Material> materialList) {
        return null;
    }
}
