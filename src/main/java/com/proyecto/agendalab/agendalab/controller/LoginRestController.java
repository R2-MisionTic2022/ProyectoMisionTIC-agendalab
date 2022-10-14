package com.proyecto.agendalab.agendalab.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.agendalab.agendalab.controller.dto.LoginSolicitud;
import com.proyecto.agendalab.agendalab.service.SecurityService;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@RestController
@RequestMapping("api/login")
public class LoginRestController {
    // post -> Insertar: Crear, para cuando no es crud
    // Get -> Consultar o Listar: Read,  la info viene por la URl
    // put -> Actualizar: Update
    // patch -> solo quiero modificar un atributo del objeto
    // Delete -> Borrar: Delete

    private final SecurityService securityService;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginSolicitud user){
        try{
            var respuesta = securityService.validarUsuario(user.getUsername(), user.getContrasena());
            return ResponseEntity.ok(respuesta);
        } catch (RuntimeException ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(ex.getMessage());
        }
    }
    
}

