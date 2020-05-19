package com.mcb.creditfactory.services.car;

import com.mcb.creditfactory.dto.CarDto;
import com.mcb.creditfactory.external.CollateralObject;
import com.mcb.creditfactory.external.CollateralType;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
public class CarAdapter implements CollateralObject {
    private final CarDto car;

    @Override
    public BigDecimal getValue() {
        return car.getAssessmentDtos().get(0).getValue();
    }

    @Override
    public Short getYear() {
        return car.getYear();
    }

    @Override
    public LocalDate getDate() {
        return car.getAssessmentDtos().get(0).getDateTime().toLocalDate();
    }

    @Override
    public CollateralType getType() {
        return CollateralType.CAR;
    }
}
