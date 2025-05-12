package com.mrd.test_pai_rest.repository;

import com.mrd.test_pai_rest.model.Plantilla;
import com.mrd.test_pai_rest.model.PlantillaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantillaRepository extends JpaRepository<Plantilla, PlantillaId> {
    // Spring Data JPA crea automáticamente los métodos CRUD (save, findAll, etc.)
}