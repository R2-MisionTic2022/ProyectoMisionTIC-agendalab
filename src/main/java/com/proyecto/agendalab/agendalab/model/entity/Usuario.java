package com.proyecto.agendalab.agendalab.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuario")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Usuario {
    
    @Id
    private String username;
    
    private Long identificacion;
    private String contrasena;
    private String nombres;
    private String apellidos;

    @Column(unique=true)
    private String email;

    private String direccion;

    private String tel_movil;

    private Boolean activo;
    
    private Boolean admin;
    
}
