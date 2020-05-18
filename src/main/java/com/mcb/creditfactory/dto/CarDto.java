package com.mcb.creditfactory.dto;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonTypeName("car")
public class CarDto implements Collateral {
    private Long id;
    private String brand;
    private String model;
    private Double power;
    private Short year;
    List<AssessmentDto> assessmentDtos;

    public CarDto(Long id) {
        this.id = id;
    }
}
