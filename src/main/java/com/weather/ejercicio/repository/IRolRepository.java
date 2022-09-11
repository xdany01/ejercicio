package com.weather.ejercicio.repository;

import com.weather.ejercicio.enums.RolEnum;
import com.weather.ejercicio.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IRolRepository extends JpaRepository<Rol, Long> {
    Optional<Rol> findByNombre(RolEnum nombre);
}
