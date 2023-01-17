package com.example.Application.repository.datajpa;

import com.example.Application.core.Material;
import com.example.Application.repository.MaterialRepository;

import java.util.List;

public class DataJpaMaterialRepository implements MaterialRepository {
    @Override
    public Material save(Material ticket) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Material get(int id) {
        return null;
    }

    @Override
    public List<Material> getAll() {
        return null;
    }
}
