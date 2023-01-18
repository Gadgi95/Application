package com.example.Application.repository;

import com.example.Application.core.Material;

import java.util.List;

public interface MaterialRepository {
    Material save(Material ticket);

    boolean delete(int id);

    Material get(int id);

    List<Material> getAll();
}
