package com.mcb.creditfactory;

import com.mcb.creditfactory.dto.CarDto;
import com.mcb.creditfactory.dto.Collateral;
import com.mcb.creditfactory.model.Car;
import com.mcb.creditfactory.service.CollateralService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CollateralServiceTests {
    @Autowired
    @Qualifier("mainCollateralService")
    CollateralService collateralService;

    @Test
    public void saveAndLoadCarDto() {
        final String brand = "BMW";
        final String model = "X1";
        final Double power = 150.;
        final Short yearOfIssue = 2011;
        final BigDecimal accessedValue = new BigDecimal(10000000);
        final CarDto car = new CarDto(null, brand, model, power, yearOfIssue, accessedValue);

        Long id = collateralService.saveCollateral(car);

        Assert.assertEquals(1L, id.longValue());

        CarDto loadedCarDto = (CarDto)collateralService.getInfo(new CarDto(id));

        Assert.assertEquals(brand, loadedCarDto.getBrand());
        Assert.assertEquals(model, loadedCarDto.getModel());
        Assert.assertEquals(power, loadedCarDto.getPower());
        Assert.assertEquals(yearOfIssue, loadedCarDto.getYear());
        Assert.assertEquals(accessedValue, loadedCarDto.getValue());
    }
}
