package com.generation.ecommerce.service;



import com.generation.ecommerce.models.Rol;
import com.generation.ecommerce.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolService {

    private final RolRepository rolRepository;

    @Autowired
    public RolService(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    public List<Rol> obtenerTodosLosRoles() {
        return rolRepository.findAll();
    }

    public Rol obtenerRolPorId(Long id) {
        return rolRepository.findById(id).orElse(null);
    }

    public Rol crearRol(Rol rol) {
        return rolRepository.save(rol);
    }

    public Rol actualizarRol(Rol rol) {
        return rolRepository.save(rol);
    }

    public void eliminarRol(Long id) {
        rolRepository.deleteById(id);
    }
}