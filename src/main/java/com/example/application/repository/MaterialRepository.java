package com.example.application.repository;

import com.example.application.model.Material;

import java.util.List;

public interface MaterialRepository {

    Material save(Material material);

    boolean delete(int id, int ticketId);

    Material get(int id);

    List<Material> getAllForTicket(int ticketId);
}
