package com.generation.ecommerce.controller;



import com.generation.ecommerce.models.Rol;
import com.generation.ecommerce.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RolController {

    private final RolService rolService;

    @Autowired
    public RolController(RolService rolService) {
        this.rolService = rolService;
    }

    @GetMapping
    public ResponseEntity<List<Rol>> obtenerTodosLosRoles() {
        return new ResponseEntity<>(rolService.obtenerTodosLosRoles(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rol> obtenerRolPorId(@PathVariable Long id) {
        Rol rol = rolService.obtenerRolPorId(id);
        return rol!= null? new ResponseEntity<>(rol, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Rol> crearRol(@RequestBody Rol rol) {
        return new ResponseEntity<>(rolService.crearRol(rol), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rol> actualizarRol(@PathVariable Long id, @RequestBody Rol rol) {
        rol.setId(id);
        return new ResponseEntity<>(rolService.actualizarRol(rol), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarRol(@PathVariable Long id) {
        rolService.eliminarRol(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}