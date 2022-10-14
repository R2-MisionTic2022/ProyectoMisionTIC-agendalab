package com.proyecto.agendalab.agendalab.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.proyecto.agendalab.agendalab.controller.dto.ExamenDto;
import com.proyecto.agendalab.agendalab.model.entity.Examen;
import com.proyecto.agendalab.agendalab.model.repository.ExamenRepository;
import com.proyecto.agendalab.agendalab.model.repository.SeccionRepository;
import com.proyecto.agendalab.agendalab.service.ExamenService;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class ExamenServiceImpl implements ExamenService{

    private final SeccionRepository seccionRepository;
    private final  ExamenRepository examenRepository;

    @Override
    public void guardarExamen(ExamenDto examen) {
        var entity = new Examen();
        entity.setCups(examen.getCups());
        entity.setExamen(examen.getExamen());
        entity.setDescripcion(examen.getDescripcion());
        entity.setValor(examen.getValor());

        var seccionOp = seccionRepository.findById(examen.getSeccion());
        entity.setSeccion(seccionOp.get());

        examenRepository.save(entity);
        
    }

    @Override
    public void borrarExamen(Long cups) {
        var examOp = examenRepository.findById(cups);
        if (examOp.isEmpty()) {
            throw new RuntimeException("El examen no existe");
        }
        examenRepository.delete(examOp.get());  
    }


    @Override
    public List<ExamenDto> listarExamenes() {
        var examenes = examenRepository.findAll();

        return examenes.stream()
                .map(exa -> new ExamenDto(exa.getCups(), exa.getExamen(), exa.getValor(), exa.getDescripcion(), exa.getSeccion().getId()))
                .collect(Collectors.toList());
    }

    @Override
    public void editarExamen(ExamenDto examen) {
        var entity = new Examen();
        entity.setCups(examen.getCups());
        entity.setExamen(examen.getExamen());
        entity.setDescripcion(examen.getDescripcion());
        entity.setValor(examen.getValor());

        var seccionOp = seccionRepository.findById(examen.getSeccion());
        entity.setSeccion(seccionOp.get());

        examenRepository.save(entity);
        
    }

    
}
