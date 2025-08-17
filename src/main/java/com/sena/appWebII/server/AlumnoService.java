package com.sena.appWebII.server;


import com.sena.appWebII.model.Alumno;
import com.sena.appWebII.model.Profesor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface AlumnoService {
    Page<Alumno> findAll(Pageable pageable);
    Optional<Alumno> findById(Integer id);
    Alumno create(Alumno alumno);
    Alumno update(Integer id, Alumno alumno);
    void deleteById(Integer id);
}
