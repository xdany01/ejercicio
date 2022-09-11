package com.weather.ejercicio.service;

import com.weather.ejercicio.enums.RolEnum;
import com.weather.ejercicio.model.Rol;

public interface IRolService {

    Rol save(Rol rol);

    Rol findByNombre(RolEnum nombre);
}
