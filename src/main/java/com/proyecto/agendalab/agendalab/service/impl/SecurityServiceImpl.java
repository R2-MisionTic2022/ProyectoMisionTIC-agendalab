package com.proyecto.agendalab.agendalab.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.proyecto.agendalab.agendalab.controller.dto.UsuarioRespuesta;
import com.proyecto.agendalab.agendalab.controller.dto.UsuarioSolicitud;
import com.proyecto.agendalab.agendalab.model.repository.UsuarioRepository;
import com.proyecto.agendalab.agendalab.service.SecurityService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SecurityServiceImpl implements SecurityService {

    private final UsuarioRepository usuariosRepository;

    @Override
    public UsuarioRespuesta validarUsuario(String username, String contrasena) {
        var userOp = usuariosRepository.findById(username);
        if(userOp.isEmpty()){
            throw new RuntimeException("Usuario no existente");
        }

        var user = userOp.get();
        if(!user.getActivo()){
            throw new RuntimeException("Usuario inactivo");
        }
        
        if(!user.getContrasena().equals(contrasena)){
           throw new RuntimeException("Credenciales inválidas");
        } 

        return UsuarioRespuesta.builder()
                .username(user.getUsername())
                .nombres(user.getNombres())
                .apellidos(user.getApellidos())
                .email(user.getEmail())
                .direccion(user.getDireccion())
                .tel_movil(user.getTel_movil())
                .admin(user.getAdmin())
                .build();

    }

    @Override
    public List<UsuarioRespuesta> getAllUsers() {
        return usuariosRepository.findAll().stream()
                .map(u -> UsuarioRespuesta.builder()
                .username(u.getUsername())
                .nombres(u.getNombres())
                .apellidos(u.getApellidos())
                .email(u.getEmail())
                .direccion(u.getDireccion())
                .tel_movil(u.getTel_movil())
                .admin(u.getAdmin())
                .build())
            .collect(Collectors.toList());
       
    }

    @Override
    public UsuarioRespuesta getUserByUsername(String username) {
        var userOp = usuariosRepository.findById(username);
        if(userOp.isEmpty()){
            throw new RuntimeException("El usuario no existe");
        }
        
        var user = userOp.get();
        return UsuarioRespuesta.builder()
                .username(user.getUsername())
                .nombres(user.getNombres())
                .apellidos(user.getApellidos())
                .email(user.getEmail())
                .direccion(user.getDireccion())
                .tel_movil(user.getTel_movil())
                .admin(user.getAdmin())
                .build();
    }

    @Override
    public void crearUsuarios(UsuarioSolicitud user) {
        
     
    }

    @Override
    public void actualizarUsuarios(UsuarioSolicitud user) {
        
        
    }

    @Override
    public void borrarUsuarios(String username) {
       
        
    }

    @Override
    public void activarUsuarios(String username) {
        
        
    }

    @Override
    public void inactivarUsuarios(String username) {
        
        
    }


}

