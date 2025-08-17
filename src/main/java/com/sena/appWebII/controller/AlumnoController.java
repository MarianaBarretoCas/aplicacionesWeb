package com.sena.appWebII.controller;

import com.sena.appWebII.model.Alumno;
import com.sena.appWebII.server.AlumnoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {

    private final AlumnoService alumnoService;

    public AlumnoController(AlumnoService alumnoService){
        this.alumnoService = alumnoService;
    }

    @GetMapping
    public Page<Alumno> getAll(@RequestParam int page, @RequestParam int size){
        PageRequest pageable = PageRequest.of(page, size);
        return alumnoService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public Alumno getById(@RequestParam Integer id){
        return alumnoService.findById(id)
                .orElseThrow(() -> new RuntimeException("Alumno not found whit id: "+ id));
    }

    @PostMapping
    public Alumno create(@RequestBody Alumno alumno){
        return alumnoService.create(alumno);
    }

    @PutMapping("/{id}")
    public Alumno update(@PathVariable Integer id, @RequestBody Alumno alumno){
        return alumnoService.update(id, alumno);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        alumnoService.deleteById(id);
    }

}
