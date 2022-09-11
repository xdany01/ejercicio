package com.weather.ejercicio.utils.validations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = EmailExistenteValidation.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface EmailExistente {
    String message() default "Ya existe una cuenta con el email ingresado.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
