package com.mcb.creditfactory.dto;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

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
    private BigDecimal value;
    private LocalDate lastAssessmentDate;

    public AirplaneDto(Long id) {
        this.id = id;
    }
}
