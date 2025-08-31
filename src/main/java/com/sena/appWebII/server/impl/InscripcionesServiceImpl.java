package com.sena.appWebII.server.impl;

import com.sena.appWebII.model.Inscripciones;
import com.sena.appWebII.repository.InscripcionesRepository;
import com.sena.appWebII.server.InscripcionesService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InscripcionesServiceImpl implements InscripcionesService {

    private final InscripcionesRepository inscripcionesRepository;

    public InscripcionesServiceImpl (InscripcionesRepository inscripcionesRepository){
        this.inscripcionesRepository = inscripcionesRepository;
    }

    @Override
    public Page<Inscripciones> findAll(Pageable pageable) {
        return inscripcionesRepository.findAll(pageable);
    }

    @Override
    public Optional<Inscripciones> findById(Long id) {
        return inscripcionesRepository.findById(id);
    }

    @Override
    public Inscripciones create(Inscripciones inscripciones) {
        return inscripcionesRepository.save(inscripciones);
    }

    @Override
    public Inscripciones update(Long id, Inscripciones inscripciones) {
        inscripciones.setId_inscripcion(id);
        return inscripcionesRepository.save(inscripciones);
    }

    @Override
    public void deleteById(Long id) {
        inscripcionesRepository.deleteById(id);
    }
}
