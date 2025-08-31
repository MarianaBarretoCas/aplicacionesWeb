package com.sena.appWebII.controller;

import com.sena.appWebII.model.Notas;
import com.sena.appWebII.server.NotasService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notas")
public class NotasController {

    private final NotasService notasService;

    public NotasController (NotasService notasService){
        this.notasService = notasService;
    }

    @GetMapping
    public Page<Notas> getAll(@RequestParam int page, @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size);
        return notasService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public Notas getById(@RequestParam Long id) {
        return notasService.findById(id)
                .orElseThrow(() -> new RuntimeException("Nota not found with id: " + id));
    }

    @PostMapping
    public Notas create(@RequestBody Notas notas){
        return notasService.create(notas);
    }

    @PutMapping("/{id}")
    public Notas update(@PathVariable Long id, @RequestBody Notas notas){
        return notasService.update(id, notas);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        notasService.deleteById(id);
    }
}
