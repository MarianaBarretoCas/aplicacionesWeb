package com.sena.appWebII.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "notas")
@Data
public class Notas{

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id_nota;

    private Integer nota;
    private String tipo_evaluacion;
    private Date fecha_evaluacion;

    @ManyToOne
    @JoinColumn(name = "id_inscripcion")
    private Inscripciones inscripciones;
}
