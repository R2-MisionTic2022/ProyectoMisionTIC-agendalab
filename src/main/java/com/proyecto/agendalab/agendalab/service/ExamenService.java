package com.proyecto.agendalab.agendalab.service;

import java.util.List;

import com.proyecto.agendalab.agendalab.controller.dto.ExamenDto;

public interface ExamenService {

    void guardarExamen(ExamenDto examen);
    
    void editarExamen (ExamenDto examen);

    void borrarExamen(Long cups);

    List<ExamenDto> listarExamenes();
   
}