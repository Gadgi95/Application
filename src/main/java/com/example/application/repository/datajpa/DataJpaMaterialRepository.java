package com.example.application.repository.datajpa;

import com.example.application.model.Material;
import com.example.application.repository.MaterialRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DataJpaMaterialRepository implements MaterialRepository {

    private static final Sort SORT_NAME = Sort.by(Sort.Direction.ASC, "name");

    CrudMaterialRepository crudMaterialRepository;

    public DataJpaMaterialRepository(CrudMaterialRepository crudMaterialRepository) {
        this.crudMaterialRepository = crudMaterialRepository;
    }

    @Override
    public Material save(Material material) {
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
