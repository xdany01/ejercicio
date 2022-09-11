package com.weather.ejercicio.service;

import com.weather.ejercicio.dto.RegisterDto;
import com.weather.ejercicio.dto.UsuarioDto;
import com.weather.ejercicio.model.Usuario;

import java.util.List;

public interface IUsuarioService {
    Usuario save(RegisterDto registerDto);

    Usuario findByEmail(String email);

    Usuario findByUsername(String userName);

    RegisterDto findByEmailDto(String email);

    RegisterDto findByUsernameDto(String userName);

    List<UsuarioDto> listAll();

}
