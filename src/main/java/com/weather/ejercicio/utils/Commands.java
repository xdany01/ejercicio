package com.weather.ejercicio.utils;

//import com.weather.ejercicio.enums.RolEnum;
//import com.weather.ejercicio.model.Rol;
//import com.weather.ejercicio.service.IRolService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@AllArgsConstructor(onConstructor_ = {@Autowired})
@Component
public class Commands implements CommandLineRunner {

//    private final IRolService rolService;

    @Override
    public void run(String... args) throws Exception {
//        Rol rolAdmin = new Rol();
//        rolAdmin.setNombre(RolEnum.ROLE_ADMIN);
//        Rol rolDefault = new Rol();
//        rolDefault.setNombre(RolEnum.ROLE_DEFAULT);
//        rolService.save(rolAdmin);
//        rolService.save(rolDefault);

    }
}
