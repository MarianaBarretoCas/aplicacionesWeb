package com.sena.appWebII.controller;

import com.sena.appWebII.model.Alumno;
import com.sena.appWebII.server.AlumnoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
