package com.proyecto.agendalab.agendalab.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.agendalab.agendalab.model.entity.Examen;

public interface ExamenRepository extends JpaRepository<Examen, Long> {
    
}
