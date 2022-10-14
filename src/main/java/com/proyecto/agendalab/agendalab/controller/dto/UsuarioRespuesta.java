package com.proyecto.agendalab.agendalab.controller.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UsuarioRespuesta {
    private String username;
    private String nombres;
    private String apellidos;
    private String email;
    private String direccion;
    private String tel_movil;
    private Boolean admin;
}
