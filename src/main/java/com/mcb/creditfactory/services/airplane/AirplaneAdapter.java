package com.mcb.creditfactory.services.airplane;

import com.mcb.creditfactory.dto.AirplaneDto;
import com.mcb.creditfactory.external.CollateralObject;
import com.mcb.creditfactory.external.CollateralType;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Provides airplane DTOs adapter for external approve service.
 */
@AllArgsConstructor
public class AirplaneAdapter implements CollateralObject {
    private final AirplaneDto airplane;

    @Override
    public BigDecimal getValue() {
        return airplane.getAssessmentDtos().get(0).getValue();
    }

    @Override
    public Short getYear() {
        return airplane.getYear();
    }

    @Override
    public LocalDate getDate() {
        return airplane.getAssessmentDtos().get(0).getDateTime().toLocalDate();
    }

    @Override
    public CollateralType getType() {
        return CollateralType.AIRPLANE;
    }
}
