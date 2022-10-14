package com.proyecto.agendalab.agendalab.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "examen")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Examen {


    @Id
    @Column(nullable = false , unique = true)
    private Long cups;

    // @Temporal(TemporalType.TIMESTAMP)
    // private Date creacion;

    @Column(nullable = false)
    private String examen;

    @Column(nullable = false)
    private Double valor;

    @ManyToOne
    private Seccion seccion;
    
    private String descripcion;

}
