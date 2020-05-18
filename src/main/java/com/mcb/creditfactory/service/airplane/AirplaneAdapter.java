package com.mcb.creditfactory.service.airplane;

import com.mcb.creditfactory.external.CollateralObject;
import com.mcb.creditfactory.external.CollateralType;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AirplaneAdapter implements CollateralObject {
    @Override
    public BigDecimal getValue() {
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
