package com.proyecto.agendalab.agendalab.service;

import java.util.List;
import java.util.Optional;

import com.proyecto.agendalab.agendalab.controller.dto.SeccionDto;


public interface SeccionService {
    
    List<SeccionDto> getSecciones();
    
    Optional<SeccionDto> getSeccionById(Integer id);

    String getNombre(Integer id);


}
