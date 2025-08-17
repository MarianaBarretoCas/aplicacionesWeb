package com.sena.appWebII.server.impl;

import com.sena.appWebII.model.Alumno;
import com.sena.appWebII.repository.AlumnoRepository;
import com.sena.appWebII.server.AlumnoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AlumnoServiceImpl implements AlumnoService {

    private final AlumnoRepository alumnoRepository;

    public AlumnoServiceImpl(AlumnoRepository alumnoRepository){
        this.alumnoRepository = alumnoRepository;
    }

    @Override
    public Page<Alumno> findAll(Pageable pageable) {
        return alumnoRepository.findAll(pageable);
    }

    @Override
    public Optional<Alumno> findById(Integer id) {
        return alumnoRepository.findById(id);
    }

    @Override
    public Alumno create(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    @Override
    public Alumno update(Integer id, Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    @Override
    public void deleteById(Integer id) {
        alumnoRepository.deleteById(id);
    }
}
