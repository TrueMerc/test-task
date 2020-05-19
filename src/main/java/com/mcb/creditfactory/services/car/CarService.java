package com.mcb.creditfactory.services.car;

import com.mcb.creditfactory.dto.CarDto;
import com.mcb.creditfactory.entities.Car;
import com.mcb.creditfactory.services.TypedCollateralObjectService;

/**
 * Provides interface for car services.
 */
public interface CarService extends TypedCollateralObjectService<Car, CarDto> {}
