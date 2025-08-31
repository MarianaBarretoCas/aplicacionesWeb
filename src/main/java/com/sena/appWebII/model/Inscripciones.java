package com.sena.appWebII.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "inscripciones")
@Data
public class Inscripciones {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id_inscripcion;

    private Integer anio_escolar;

    @ManyToOne
    @JoinColumn(name = "id_alumno")
    private Alumno alumno;

    @ManyToOne
    @JoinColumn(name = "id_asignatura")
    private Asignatura asignatura;


}
