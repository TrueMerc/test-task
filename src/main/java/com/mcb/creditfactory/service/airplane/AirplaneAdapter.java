package com.mcb.creditfactory.service.airplane;

import com.mcb.creditfactory.external.CollateralObject;
import com.mcb.creditfactory.external.CollateralType;
import com.mcb.creditfactory.model.Airplane;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
public class AirplaneAdapter implements CollateralObject {
    private final Airplane airplane;

    @Override
    public BigDecimal getValue() {
        //return airplane.g;
        return null;
    }

    @Override
    public Short getYear() {
        return null;
    }

    @Override
    public LocalDate getDate() {
        return null;
    }

    @Override
    public CollateralType getType() {
        return null;
    }
}
