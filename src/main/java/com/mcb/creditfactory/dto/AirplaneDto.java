package com.mcb.creditfactory.dto;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonTypeName("airplane")
public class AirplaneDto implements Collateral {
    private Long id;
    private String brand;
    private String model;
    private String manufacturer;
    private Integer fuelCapacity;
    private Short year;
    private Short seats;
    private List<AssessmentDto> assessmentDtos;

    public AirplaneDto(Long id) {
        this.id = id;
    }

    public AirplaneDto(
            String brand, String model, String manufacturer, Integer fuelCapacity,
            Short year, Short seats, List<AssessmentDto> assessmentDtos
    ) {
        this.id = null;
        this.brand = brand;
        this.model = model;
        this.manufacturer = manufacturer;
        this.fuelCapacity = fuelCapacity;
        this.year = year;
        this.seats = seats;
        this.assessmentDtos = assessmentDtos;
    }
}
