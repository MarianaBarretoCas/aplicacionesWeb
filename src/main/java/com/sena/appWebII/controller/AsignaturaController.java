package com.sena.appWebII.controller;

import com.sena.appWebII.model.Asignatura;
import com.sena.appWebII.server.AsignaturaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/asignaturas")
public class AsignaturaController {

    private final AsignaturaService asignaturaService;

    public AsignaturaController (AsignaturaService asignaturaService){
        this.asignaturaService = asignaturaService;
    }

    @GetMapping
    public Page<Asignatura> getAll(@RequestParam int page, @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size);
        return asignaturaService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public Asignatura getById(@RequestParam Long id) {
        return asignaturaService.findById(id)
                .orElseThrow(() -> new RuntimeException("Asignatura not found with id: " + id));
    }

    @PostMapping
    public Asignatura create(@RequestBody Asignatura asignatura){
        return asignaturaService.create(asignatura);
    }

    @PutMapping("/{id}")
    public Asignatura update(@PathVariable Long id, @RequestBody Asignatura asignatura){
        return asignaturaService.update(id, asignatura);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        asignaturaService.deleteById(id);
    }
}
