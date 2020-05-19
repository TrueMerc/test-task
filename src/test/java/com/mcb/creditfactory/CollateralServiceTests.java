package com.mcb.creditfactory;

import com.mcb.creditfactory.dto.AirplaneDto;
import com.mcb.creditfactory.dto.AssessmentDto;
import com.mcb.creditfactory.dto.CarDto;
import com.mcb.creditfactory.entities.Airplane;
import com.mcb.creditfactory.services.CollateralService;
import com.mcb.creditfactory.services.car.CarAdapter;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
        final List<AssessmentDto> assessments = new ArrayList<>();
        assessments.add(new AssessmentDto(null, LocalDateTime.now().plusMonths(1), accessedValue));
        assessments.add(new AssessmentDto(null, LocalDateTime.now().minusMonths(1), accessedValue));
        assessments.add(new AssessmentDto(null, LocalDateTime.now(), accessedValue));
        final CarDto car = new CarDto(null, brand, model, power, yearOfIssue, assessments);

        Long id = collateralService.saveCollateral(car);

        Assert.assertEquals(1L, id.longValue());

        CarDto loadedCarDto = (CarDto)collateralService.getInfo(new CarDto(id));

        Assert.assertEquals(brand, loadedCarDto.getBrand());
        Assert.assertEquals(model, loadedCarDto.getModel());
        Assert.assertEquals(power, loadedCarDto.getPower());
        Assert.assertEquals(yearOfIssue, loadedCarDto.getYear());
        Assert.assertEquals(assessments.size(), loadedCarDto.getAssessmentDtos().size());

        CarAdapter adapter = new CarAdapter(loadedCarDto);
        Assert.assertEquals(LocalDate.now().plusMonths(1), adapter.getDate());
        Assert.assertEquals(accessedValue, adapter.getValue());
    }

    @Test
    public void saveAndLoadAirplaneDto() {
        final String brand = "Boeing";
        final String model = "737-800";
        final String manufacturer = "Boeing Company";
        final Integer fuelCapacity = 1000;
        final Short yearOfIssue = 1998;
        final Short seats = 175;
        final BigDecimal accessedValue = new BigDecimal(2500000000L);
        final List<AssessmentDto> assessments = new ArrayList<>();
        assessments.add(new AssessmentDto(null, LocalDateTime.now().plusMonths(1), accessedValue));
        assessments.add(new AssessmentDto(null, LocalDateTime.now().minusMonths(1), accessedValue));
        assessments.add(new AssessmentDto(null, LocalDateTime.now(), accessedValue));
        final AirplaneDto airplaneDto = new AirplaneDto(
                null, brand, model, manufacturer, fuelCapacity, yearOfIssue, seats, assessments
        );

        Long id = collateralService.saveCollateral(airplaneDto);

        Assert.assertEquals(1L, id.longValue());

        AirplaneDto loadedAirplaneDto = (AirplaneDto)collateralService.getInfo(new AirplaneDto(id));

        Assert.assertEquals(brand, loadedAirplaneDto.getBrand());
        Assert.assertEquals(model, loadedAirplaneDto.getModel());
        Assert.assertEquals(manufacturer, loadedAirplaneDto.getManufacturer());
        Assert.assertEquals(fuelCapacity, loadedAirplaneDto.getFuelCapacity());
        Assert.assertEquals(yearOfIssue, loadedAirplaneDto.getYear());
        Assert.assertEquals(yearOfIssue, loadedAirplaneDto.getYear());
        Assert.assertEquals(assessments.size(), loadedAirplaneDto.getAssessmentDtos().size());
    }
}
