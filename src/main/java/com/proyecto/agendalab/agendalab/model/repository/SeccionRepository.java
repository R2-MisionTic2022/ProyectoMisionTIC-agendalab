package com.proyecto.agendalab.agendalab.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.agendalab.agendalab.model.entity.Seccion;

public interface SeccionRepository extends JpaRepository<Seccion, Integer> {

   Optional<Seccion> findByNombre(String string);
   
   Optional<Seccion> findById(Integer id);
    
}
