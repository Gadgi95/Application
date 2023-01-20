package com.example.Application.repository.datajpa;

import com.example.Application.core.Material;
import com.example.Application.repository.MaterialRepository;

import java.util.List;

public class DataJpaMaterialRepository implements MaterialRepository {

    @Override
    public Material save(Material material, int ticketId) {
        return null;
    }

    @Override
    public boolean delete(int id, int ticketId) {
        return false;
    }

    @Override
    public Material get(int id, int ticketId) {
        return null;
    }

    @Override
    public List<Material> getAll(int ticketId) {
        return null;
    }
}
