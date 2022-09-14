package com.weather.ejercicio.controller;

import com.weather.ejercicio.dto.RegisterDto;
import com.weather.ejercicio.model.Ciudad;
import com.weather.ejercicio.service.ICiudadService;
import com.weather.ejercicio.service.IUsuarioService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@AllArgsConstructor(onConstructor_ = {@Autowired})
@Slf4j
@Controller
public class MainController {

    private final IUsuarioService usuarioService;
    private final ICiudadService ciudadService;

    @GetMapping("/clima")
    public ModelAndView clima() {
        ModelAndView model = new ModelAndView("clima");
        model.addObject("clima", ciudadService.listAll());
//        List<Ciudad> ciudades = ciudadService.listAll();
//        ciudades.forEach(ciudad -> log.info(new Date(ciudad.getUpdated()).toString()));
        return model;
    }

    @GetMapping(path = {"/", "/login"})
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public ModelAndView register() {
        ModelAndView model = new ModelAndView("register");
        model.addObject("usuario", new RegisterDto());
        return model;
    }

    @GetMapping("/usuarios")
    public ModelAndView usuarios() {
        ModelAndView model = new ModelAndView("usuarios");
        model.addObject("usuarios", usuarioService.listAll());
        return model;
    }

    @PostMapping("/register")
    public ModelAndView register(@Valid @ModelAttribute("usuario") RegisterDto usuario, BindingResult bd) {
        ModelAndView model = new ModelAndView("register");
        if (!bd.hasErrors()) {
            usuarioService.save(usuario);
            return new ModelAndView("redirect:/login");
        } else {
            model.addObject("usuario", usuario);
            return model;
        }
    }
}
