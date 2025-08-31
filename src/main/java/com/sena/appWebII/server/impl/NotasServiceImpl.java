package com.sena.appWebII.server.impl;

import com.sena.appWebII.model.Notas;
import com.sena.appWebII.repository.AsignaturaRepository;
import com.sena.appWebII.repository.NotasRepository;
import com.sena.appWebII.server.NotasService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NotasServiceImpl implements NotasService {

    private final NotasRepository notasRepository;

    public NotasServiceImpl ( NotasRepository notasRepository){
        this.notasRepository = notasRepository;
    }

    @Override
    public Page<Notas> findAll(Pageable pageable) {
        return notasRepository.findAll(pageable);
    }

    @Override
    public Optional<Notas> findById(Long id) {
        return notasRepository.findById(id);
    }

    @Override
    public Notas create(Notas notas) {
        return notasRepository.save(notas);
    }

    @Override
    public Notas update(Long id, Notas notas) {
        notas.setId_nota(id);
        return notasRepository.save(notas);
    }

    @Override
    public void deleteById(Long id) {
        notasRepository.deleteById(id);
    }
}
