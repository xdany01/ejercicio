package com.weather.ejercicio.service;

import com.weather.ejercicio.model.Ciudad;

import java.util.List;

public interface ICiudadService {
    Ciudad save(Ciudad ciudad);

    Ciudad findBy_Id(String id);

    List<Ciudad> listAll();
}
