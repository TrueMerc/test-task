package com.mcb.creditfactory.services.car;

import com.mcb.creditfactory.dto.CarDto;
import com.mcb.creditfactory.dto.Collateral;
import com.mcb.creditfactory.services.TypedCollateralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarCollateralService implements TypedCollateralService {
    @Autowired
    CarService carService;

    @Override
    public Long saveCollateral(Collateral object) {
        if (!(object instanceof CarDto)) {
            throw new IllegalArgumentException();
      }

        CarDto car = (CarDto) object;
        boolean approved = carService.approve(car);
        if (!approved) {
            return null;
        }

        return Optional.of(car)
                .map(carService::fromDto)
                .map(carService::save)
                .map(carService::getId)
                .orElse(null);
    }

    @Override
    public Collateral getInfo(Collateral object) {
        if (!(object instanceof CarDto)) {
            throw new IllegalArgumentException();
        }
        return Optional.of((CarDto) object)
                .map(carService::fromDto)
                .map(carService::getId)
                .flatMap(carService::load)
                .map(carService::toDTO)
                .orElse(null);
    }

    @Override
    public String typeId() {
        return CarDto.class.toString();
    }
}
