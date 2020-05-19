package com.mcb.creditfactory.repositories;

import com.mcb.creditfactory.entities.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Long> {}
