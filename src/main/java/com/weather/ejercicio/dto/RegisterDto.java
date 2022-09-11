package com.weather.ejercicio.dto;

import com.weather.ejercicio.utils.validations.EmailExistente;
import com.weather.ejercicio.utils.validations.UsernameExistente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDto {
    private Long id;
    @NotBlank(message = "El campo username es obligatorio.")
    @Length(min = 3, message = "Minimo 3 caracteres.")
    @UsernameExistente
    private String username;
    @NotBlank(message = "El campo email es obligatorio.")
    @Email(message = "El formato del email no es valido.")
    @EmailExistente
    private String email;
    @NotBlank(message = "El campo password es obligatorio.")
    private String password;
}
