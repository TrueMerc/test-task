package com.mcb.creditfactory;

import com.mcb.creditfactory.model.Car;
import com.mcb.creditfactory.service.car.CarService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestTaskApplicationTests {

    @Autowired
    CarService carService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void saveAndLoadCar() {
        final String brand = "BMW";
        final String model = "X1";
        final Double power = 150.;
        final Short yearOfIssue = 2011;
        final BigDecimal accessedValue = new BigDecimal(10000);
        final Car car = new Car(null, brand, model, power, yearOfIssue, accessedValue);

        carService.save(car);

        Long id = carService.getId(car);
        Assert.assertEquals(1L, id.longValue());

        Car loadedCar = carService.load(id).get();

        Assert.assertEquals(brand, loadedCar.getBrand());
        Assert.assertEquals(model, loadedCar.getModel());
        Assert.assertEquals(power, loadedCar.getPower());
        Assert.assertEquals(yearOfIssue, loadedCar.getYear());
        Assert.assertEquals(accessedValue, loadedCar.getValue());
    }
}
