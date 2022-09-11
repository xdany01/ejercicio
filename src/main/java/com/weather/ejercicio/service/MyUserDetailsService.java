package com.weather.ejercicio.service;

import com.weather.ejercicio.model.MyUserDetails;
import com.weather.ejercicio.model.Usuario;
import com.weather.ejercicio.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByUsername(username).orElse(usuarioRepository.findByEmail(username).orElse(null));
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario no encontrado.");
        }
        return new MyUserDetails(usuario);
    }
}
