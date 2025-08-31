package com.sena.appWebII.server;

import com.sena.appWebII.model.Asignatura;
import org.springframework.data.domain.*;

import java.util.Optional;

public interface AsignaturaService {
    Page<Asignatura> findAll(Pageable pageable);
    Optional<Asignatura> findById(Long id);
    Asignatura create(Asignatura asignatura);
    Asignatura update(Long id, Asignatura asignatura);
    void deleteById(Long id);
}
