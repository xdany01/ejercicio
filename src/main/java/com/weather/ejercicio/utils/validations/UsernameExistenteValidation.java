package com.weather.ejercicio.utils.validations;

import com.weather.ejercicio.model.Usuario;
import com.weather.ejercicio.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UsernameExistenteValidation implements ConstraintValidator<UsernameExistente, String> {

    @Autowired
    private IUsuarioService usuarioService;
    private boolean retorno;

    @Override
    public void initialize(UsernameExistente constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        retorno = false;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        Usuario usuario = usuarioService.findByUsername(value);
        if (usuario == null && value != null) {
            retorno = true;
        }
        return retorno;
    }
}
