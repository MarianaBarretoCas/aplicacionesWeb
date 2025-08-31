package com.sena.appWebII.server;

import com.sena.appWebII.model.Notas;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface NotasService {

    Page<Notas> findAll(Pageable pageable);
    Optional<Notas> findById(Long id);
    Notas create(Notas notas);
    Notas update(Long id, Notas notas);
    void deleteById(Long id);

}
