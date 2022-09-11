package com.weather.ejercicio.repository;

import com.weather.ejercicio.model.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ICiudadRepository extends JpaRepository<Ciudad, Long> {
    Optional<Ciudad> findBy_id(String id);
}
