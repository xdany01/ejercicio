package com.weather.ejercicio.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "ciudad")
public class Ciudad implements Serializable {
    @Id
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
