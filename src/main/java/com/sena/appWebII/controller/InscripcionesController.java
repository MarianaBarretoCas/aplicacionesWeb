package com.sena.appWebII.controller;

import com.sena.appWebII.model.Asignatura;
import com.sena.appWebII.model.Inscripciones;
import com.sena.appWebII.server.InscripcionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inscripciones")
public class InscripcionesController {

    @Autowired
    private InscripcionesService inscripcionesService;

    @GetMapping
    public Page<Inscripciones> getAll(@RequestParam int page, @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size);
        return inscripcionesService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public Inscripciones getById(@RequestParam Long id) {
        return inscripcionesService.findById(id)
                .orElseThrow(() -> new RuntimeException("inscripcion not found with id: " + id));
    }

    @PostMapping
    public Inscripciones create(@RequestBody Inscripciones inscripciones){
        return inscripcionesService.create(inscripciones);
    }

    @PutMapping("/{id}")
    public Inscripciones update(@PathVariable Long id, @RequestBody Inscripciones inscripciones){
        return inscripcionesService.update(id, inscripciones);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        inscripcionesService.deleteById(id);
    }
}
