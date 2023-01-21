package com.example.Application.repository;

import com.example.Application.core.Material;

import java.util.List;

public interface MaterialRepository {

    Material save(Material material);

    boolean delete(int id, int ticketId);

    Material get(String name);

    List<Material> getAll();
}
