package com.weather.ejercicio.service;

import com.weather.ejercicio.model.Ciudad;
import com.weather.ejercicio.repository.ICiudadRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor(onConstructor_ = {@Autowired})
@Service
@Transactional
public class CiudadService implements ICiudadService {
    private final ICiudadRepository ciudadRepository;

    @Override
    public Ciudad save(Ciudad ciudad) {
        return ciudadRepository.save(ciudad);
    }

    @Override
    public Ciudad findBy_Id(String id) {
        return ciudadRepository.findBy_id(id).orElse(null);
    }

    @Override
    public List<Ciudad> listAll() {
        return ciudadRepository.findAll();
    }
}
