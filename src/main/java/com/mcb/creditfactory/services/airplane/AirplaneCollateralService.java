package com.mcb.creditfactory.services.airplane;

import com.mcb.creditfactory.dto.AirplaneDto;
import com.mcb.creditfactory.dto.Collateral;
import com.mcb.creditfactory.services.TypedCollateralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Provides collateral service implementation for airplane collateral objects.
 */
@Service
public class AirplaneCollateralService implements TypedCollateralService {

    private final AirplaneService airplaneService;

    public AirplaneCollateralService(AirplaneService airplaneService) {
        this.airplaneService = airplaneService;
    }

    @Override
    public Long saveCollateral(Collateral object) {
        if (!(object instanceof AirplaneDto)) {
            throw new IllegalArgumentException();
        }

        AirplaneDto airplane = (AirplaneDto) object;
        boolean approved = airplaneService.approve(airplane);
        if (!approved) {
            return null;
        }

        return Optional.of(airplane)
                .map(airplaneService::fromDto)
                .map(airplaneService::save)
                .map(airplaneService::getId)
                .orElse(null);
    }

    @Override
    public Collateral getInfo(Collateral object) {
        if (!(object instanceof AirplaneDto)) {
            throw new IllegalArgumentException();
        }
        return Optional.of((AirplaneDto) object)
                .map(airplaneService::fromDto)
                .map(airplaneService::getId)
                .flatMap(airplaneService::load)
                .map(airplaneService::toDTO)
                .orElse(null);
    }

    @Override
    public String typeId() {
        return AirplaneDto.class.toString();
    }
}
