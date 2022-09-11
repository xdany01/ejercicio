package com.weather.ejercicio.utils;

import com.weather.ejercicio.dto.CiudadDto;
import com.weather.ejercicio.model.Ciudad;
import com.weather.ejercicio.service.ICiudadService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@AllArgsConstructor(onConstructor_ = {@Autowired})
@Component
public class ScheduledTasks {
    private ICiudadService ciudadService;

    @Scheduled(fixedRate = 5000)
    public void fixedRateSch() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://ws.smn.gob.ar/map_items/weather";
        CiudadDto[] ciudades = restTemplate.getForObject(url, CiudadDto[].class);
        Ciudad ciudad;
        for (CiudadDto c : ciudades) {
            Ciudad ciudadDb = ciudadService.findBy_Id(c.get_id());
            if (ciudadDb != null) {
                ciudad = mapperCiudad(c, ciudadDb);
                ciudadService.save(ciudad);
            } else {
                ciudad = mapperCiudad(c, new Ciudad());
                ciudadService.save(ciudad);
            }
        }
    }

    private Ciudad mapperCiudad(CiudadDto ciudadDto, Ciudad ciudad) {
        ciudad.set_id(ciudadDto.get_id());
        ciudad.setDist(ciudadDto.getDist());
        ciudad.setLid(ciudadDto.getLid());
        ciudad.setFid(ciudadDto.getFid());
        ciudad.setInt_number(ciudadDto.getInt_number());
        ciudad.setName(ciudadDto.getName());
        ciudad.setProvince(ciudadDto.getProvince());
        ciudad.setLat(ciudadDto.getLat());
        ciudad.setLon(ciudadDto.getLon());
        ciudad.setZoom(ciudadDto.getZoom());
        ciudad.setUpdated(ciudadDto.getUpdated());
        ciudad.setHumidity(ciudadDto.getWeather().getHumidity());
        ciudad.setPressure(ciudadDto.getWeather().getPressure());
        ciudad.setSt(ciudadDto.getWeather().getSt());
        ciudad.setVisibility(ciudadDto.getWeather().getVisibility());
        ciudad.setWind_speed(ciudadDto.getWeather().getWind_speed());
        ciudad.setDescription(ciudadDto.getWeather().getDescription());
        ciudad.setTemp(ciudadDto.getWeather().getTemp());
        ciudad.setWing_deg(ciudadDto.getWeather().getWing_deg());
        ciudad.setTempDesc(ciudadDto.getWeather().getTempDesc());
        return ciudad;
    }
}
