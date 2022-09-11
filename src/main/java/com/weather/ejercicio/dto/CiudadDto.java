package com.weather.ejercicio.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CiudadDto {
    private String _id;
    private Double dist;
    private Integer lid;
    private Integer fid;
    private Integer int_number;
    private String name;
    private String province;
    private String lat;
    private String lon;
    private String zoom;
    private Long updated;
    private WeatherDto weather;
}
