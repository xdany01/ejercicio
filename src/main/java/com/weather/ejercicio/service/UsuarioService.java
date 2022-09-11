package com.weather.ejercicio.service;

import com.weather.ejercicio.dto.RegisterDto;
import com.weather.ejercicio.dto.UsuarioDto;
import com.weather.ejercicio.enums.RolEnum;
import com.weather.ejercicio.model.Rol;
import com.weather.ejercicio.model.Usuario;
import com.weather.ejercicio.repository.IUsuarioRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor(onConstructor_ = {@Autowired})
@Service
@Transactional
public class UsuarioService implements IUsuarioService {
    private final ModelMapper modelMapper;
    private final IUsuarioRepository usuarioRepository;
    private final IRolService rolService;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public Usuario save(RegisterDto registerDto) {
        Usuario usuario = modelMapper.map(registerDto, Usuario.class);
        usuario.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        usuario.setActivo(true);
        Rol rol = rolService.findByNombre(RolEnum.ROLE_DEFAULT);
        usuario.setRol(rol);
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario findByEmail(String email) {
        return usuarioRepository.findByEmail(email).orElse(null);
    }

    @Override
    public Usuario findByUsername(String userName) {
        return usuarioRepository.findByUsername(userName).orElse(null);
    }

    @Override
    public RegisterDto findByEmailDto(String email) {
        Usuario usuario = usuarioRepository.findByEmail(email).orElse(new Usuario());
        return modelMapper.map(usuario, RegisterDto.class);
    }

    @Override
    public RegisterDto findByUsernameDto(String userName) {
        Usuario usuario = usuarioRepository.findByUsername(userName).orElse(new Usuario());
        return modelMapper.map(usuario, RegisterDto.class);
    }

    @Override
    public List<UsuarioDto> listAll() {
        List<Usuario> usuarioList = usuarioRepository.findAllByActivoIsTrue();
        List<UsuarioDto> usuarioDtoList = new ArrayList<>();
        for (Usuario usuarioTemp : usuarioList) {
            UsuarioDto usuarioDtoTemp = modelMapper.map(usuarioTemp, UsuarioDto.class);
            usuarioDtoTemp.setRolEnum(usuarioDtoTemp.getRol().getNombre().name());
            if (!usuarioDtoList.contains(usuarioDtoTemp)) {
                usuarioDtoList.add(usuarioDtoTemp);
            }
        }
        return usuarioDtoList;
    }

}
