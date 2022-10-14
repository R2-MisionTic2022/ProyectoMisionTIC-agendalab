package com.proyecto.agendalab.agendalab.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.proyecto.agendalab.agendalab.controller.dto.SeccionDto;
import com.proyecto.agendalab.agendalab.model.repository.SeccionRepository;
import com.proyecto.agendalab.agendalab.service.SeccionService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SeccionServiceImpl implements SeccionService {

    private final SeccionRepository seccionRepository;

    @Override
    public List<SeccionDto> getSecciones() {
        var secciones = seccionRepository.findAll(Sort.by("nombre"));

        return secciones.stream()
                .map(sec -> new SeccionDto(sec.getNombre(), sec.getId()))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<SeccionDto> getSeccionById(Integer id) {
        var seccion = seccionRepository.findById(id);

        if (seccion.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(new SeccionDto(
                seccion.get().getNombre(),
                seccion.get().getId()));
    }

    @Override
    public String getNombre(Integer id) {
        var seccionOp = seccionRepository.findById(id);

        var seccionBd = seccionOp.get().getNombre(); 
        
        return seccionBd;
    }
}
