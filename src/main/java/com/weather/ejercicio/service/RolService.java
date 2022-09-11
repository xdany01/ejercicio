package com.weather.ejercicio.service;

import com.weather.ejercicio.enums.RolEnum;
import com.weather.ejercicio.model.Rol;
import com.weather.ejercicio.repository.IRolRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@AllArgsConstructor(onConstructor_ = {@Autowired})
@Service
@Transactional
public class RolService implements IRolService {
    private final IRolRepository rolRepository;

    @Override
    public Rol save(Rol rol) {
        return rolRepository.save(rol);
    }

    @Override
    public Rol findByNombre(RolEnum nombre) {
        return rolRepository.findByNombre(nombre).orElse(null);
    }
}
