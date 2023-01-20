package com.example.Application.repository;

import com.example.Application.core.Material;

import java.util.List;

public interface MaterialRepository {

    Material save(Material material, int ticketId);

    boolean delete(int id, int ticketId);

    Material get(int id, int ticketId);

    List<Material> getAll(int ticketId);
}
