package com.proyecto.agendalab.agendalab.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginSolicitud {
    private String username;
    private String contrasena;  
}
