package com.sena.appWebII.server.impl;

import com.sena.appWebII.model.Asignatura;
import com.sena.appWebII.repository.AsignaturaRepository;
import com.sena.appWebII.server.AsignaturaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AsignaturaServiceImpl implements AsignaturaService {

    private final AsignaturaRepository asignaturaRepository;

    public AsignaturaServiceImpl (AsignaturaRepository asignaturaRepository){
        this.asignaturaRepository = asignaturaRepository;
    }

    @Override
    public Page<Asignatura> findAll(Pageable pageable) {
        return asignaturaRepository.findAll(pageable);
    }

    @Override
    public Optional<Asignatura> findById(Long id) {
        return asignaturaRepository.findById(id);
    }

    @Override
    public Asignatura create(Asignatura asignatura) {
        return asignaturaRepository.save(asignatura);
    }

    @Override
    public Asignatura update(Long id, Asignatura asignatura) {
        asignatura.setId_asignatura(id);
        return asignaturaRepository.save(asignatura);
    }

    @Override
    public void deleteById(Long id) {
        asignaturaRepository.deleteById(id);
    }
}
