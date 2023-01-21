package com.example.Application.repository.datajpa;

import com.example.Application.core.Material;
import com.example.Application.repository.MaterialRepository;
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
    public Material get(String name) {
        return crudMaterialRepository.findByName(name);
    }

    @Override
    public List<Material> getAll() {
        return crudMaterialRepository.findAll(SORT_NAME);
    }
}
