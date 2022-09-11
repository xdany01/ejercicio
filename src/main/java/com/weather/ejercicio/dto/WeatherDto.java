package com.weather.ejercicio.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WeatherDto {
    private Integer humidity;
    private Double pressure;
    private Double st;
    private Integer visibility;
    private Integer wind_speed;
    private String description;
    private Double temp;
    private String wing_deg;
    private String tempDesc;
}
