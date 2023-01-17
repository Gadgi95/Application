package com.example.Application.repository.datajpa;

import com.example.Application.core.Material;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrudMaterialRepository extends JpaRepository<Material, Integer> {
}
