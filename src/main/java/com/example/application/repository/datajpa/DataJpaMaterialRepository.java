package com.example.application.repository.datajpa;

import com.example.application.model.Material;
import com.example.application.model.Ticket;
import com.example.application.repository.MaterialRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DataJpaMaterialRepository implements MaterialRepository {

    private static final Sort SORT_NAME = Sort.by(Sort.Direction.ASC, "name");

    private final CrudTicketRepository crudTicketRepository;

    private final CrudMaterialRepository crudMaterialRepository;

    public static Ticket temp;

    public DataJpaMaterialRepository(CrudTicketRepository crudTicketRepository, CrudMaterialRepository crudMaterialRepository) {
        this.crudTicketRepository = crudTicketRepository;
        this.crudMaterialRepository = crudMaterialRepository;
    }

    @Override
    @Transactional
    public Material save(Material material) {
        if (material.getId() != null) {
            temp = crudTicketRepository.getById(crudMaterialRepository.getById(material.getId()).getTicket().getId());
            material.setTicket(temp);
        }
        return crudMaterialRepository.save(material);
    }

    @Override
    public boolean delete(int id, int ticketId) {
        return crudMaterialRepository.delete(id, ticketId) != 0;
    }

    @Override
    public Material get(int id) {
        if (crudMaterialRepository.findById(id) == null) {
            return null;
        }
        return crudMaterialRepository.findById(id);
    }

    @Override
    public List<Material> getAllForTicket(int ticketId) {
        return crudMaterialRepository.getAllForTicket(ticketId);
    }
}
