package com.weather.ejercicio.dto;

import com.weather.ejercicio.model.Rol;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDto {
    private Long id;
    private String username;
    private String email;
    private boolean activo;
    private Rol rol;
    private String rolEnum;
}
