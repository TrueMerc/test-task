package com.mcb.creditfactory;

import com.mcb.creditfactory.entities.Assessment;
import com.mcb.creditfactory.entities.Car;
import com.mcb.creditfactory.services.car.CarService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarServiceTests {
    @Autowired
    CarService carService;

    @Test
    public void saveAndLoadCar() {
        final String brand = "BMW";
        final String model = "X1";
        final Double power = 150.;
        final Short yearOfIssue = 2011;
        final BigDecimal accessedValue = new BigDecimal(10000);
        final List<Assessment> assessments = new ArrayList<>();
        assessments.add(new Assessment(null, LocalDateTime.now().plusMonths(1), accessedValue));
        assessments.add(new Assessment(null, LocalDateTime.now().minusMonths(1), accessedValue));
        assessments.add(new Assessment(null, LocalDateTime.now(), accessedValue));
        final Car car = new Car(null, brand, model, power, yearOfIssue, assessments);

        carService.save(car);

        Long id = carService.getId(car);
        Assert.assertEquals(1L, id.longValue());

        Optional<Car> loaded = carService.load(id);
        Assert.assertTrue(loaded.isPresent());
        Car loadedCar = loaded.get();

        Assert.assertEquals(brand, loadedCar.getBrand());
        Assert.assertEquals(model, loadedCar.getModel());
        Assert.assertEquals(power, loadedCar.getPower());
        Assert.assertEquals(yearOfIssue, loadedCar.getYear());
    }
}
