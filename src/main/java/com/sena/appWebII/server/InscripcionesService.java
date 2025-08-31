package com.sena.appWebII.server;

import com.sena.appWebII.model.Inscripciones;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface InscripcionesService {
    Page<Inscripciones> findAll(Pageable pageable);
    Optional<Inscripciones> findById(Long id);
    Inscripciones create(Inscripciones inscripciones);
    Inscripciones update(Long id, Inscripciones inscripciones);
    void deleteById(Long id);

}
