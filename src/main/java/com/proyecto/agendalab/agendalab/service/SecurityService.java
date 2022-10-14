package com.proyecto.agendalab.agendalab.service;

import java.util.List;

import com.proyecto.agendalab.agendalab.controller.dto.UsuarioRespuesta;
import com.proyecto.agendalab.agendalab.controller.dto.UsuarioSolicitud;


public interface SecurityService {

    UsuarioRespuesta validarUsuario(String username, String contrasena);

    List<UsuarioRespuesta> getAllUsers();

    UsuarioRespuesta getUserByUsername(String username);

    void crearUsuarios(UsuarioSolicitud user);

    void actualizarUsuarios(UsuarioSolicitud user);

    void borrarUsuarios(String username);

    void activarUsuarios(String username);

    void inactivarUsuarios(String username);
    }
