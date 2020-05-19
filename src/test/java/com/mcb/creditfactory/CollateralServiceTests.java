package com.mcb.creditfactory;

import com.mcb.creditfactory.dto.AirplaneDto;
import com.mcb.creditfactory.dto.AssessmentDto;
import com.mcb.creditfactory.dto.CarDto;
import com.mcb.creditfactory.entities.Car;
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

    private final LocalDateTime now = LocalDateTime.now();
    private final Long firstEntityExpectedId = 1L;
    private final BigDecimal defaultCarAssessedValue = new BigDecimal(10000000);

    @Test
    public void saveAndLoadCarDto() {
        final CarDto carDto = getDefaultCarDto();

        Long id = collateralService.saveCollateral(carDto);

        Assert.assertEquals(firstEntityExpectedId, id);

        CarDto loadedCarDto = (CarDto)collateralService.getInfo(new CarDto(id));
        this.assertEquals(carDto, loadedCarDto);

        CarAdapter adapter = new CarAdapter(loadedCarDto);
        Assert.assertEquals(LocalDate.now().plusMonths(1), adapter.getDate());
        Assert.assertEquals(defaultCarAssessedValue, adapter.getValue());
    }

    CarDto getDefaultCarDto() {
        final String brand = "BMW";
        final String model = "X1";
        final Double power = 150.;
        final Short yearOfIssue = 2011;
        final List<AssessmentDto> assessments = new ArrayList<>();
        assessments.add(new AssessmentDto(now.plusMonths(1), defaultCarAssessedValue));
        assessments.add(new AssessmentDto(now.minusMonths(1), defaultCarAssessedValue));
        assessments.add(new AssessmentDto(now, defaultCarAssessedValue));
        return new CarDto(brand, model, power, yearOfIssue, assessments);
    }

    void assertEquals(CarDto expected, CarDto loaded) {
        Assert.assertEquals(expected.getBrand(), loaded.getBrand());
        Assert.assertEquals(expected.getModel(), loaded.getModel());
        Assert.assertEquals(expected.getPower(), loaded.getPower());
        Assert.assertEquals(expected.getYear(), loaded.getYear());
        Assert.assertEquals(expected.getAssessmentDtos().size(), loaded.getAssessmentDtos().size());
    }

    @Test
    public void addNewCarAssessment() {
        CarDto carDto = getDefaultCarDto();
        collateralService.saveCollateral(carDto);
        final CarDto firstCarDto = new CarDto(firstEntityExpectedId);
        carDto = (CarDto)collateralService.getInfo(firstCarDto);
        carDto.getAssessmentDtos().add(new AssessmentDto(now.plusMonths(2), defaultCarAssessedValue));
        collateralService.saveCollateral(carDto);
        carDto = (CarDto)collateralService.getInfo(firstCarDto);
        Assert.assertEquals(now.plusMonths(2).toLocalDate(), new CarAdapter(carDto).getDate());
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
        assessments.add(new AssessmentDto(now.plusMonths(1), accessedValue));
        assessments.add(new AssessmentDto(now.minusMonths(1), accessedValue));
        assessments.add(new AssessmentDto(now, accessedValue));
        final AirplaneDto airplaneDto = new AirplaneDto(
                brand, model, manufacturer, fuelCapacity, yearOfIssue, seats, assessments
        );

        Long id = collateralService.saveCollateral(airplaneDto);

        Assert.assertEquals(firstEntityExpectedId, id);

        AirplaneDto loadedAirplaneDto = (AirplaneDto)collateralService.getInfo(new AirplaneDto(id));
        this.assertEquals(airplaneDto, loadedAirplaneDto);
    }
    
    void assertEquals(AirplaneDto expected, AirplaneDto loaded) {
        Assert.assertEquals(expected.getBrand(), loaded.getBrand());
        Assert.assertEquals(expected.getModel(), loaded.getModel());
        Assert.assertEquals(expected.getManufacturer(), loaded.getManufacturer());
        Assert.assertEquals(expected.getFuelCapacity(), loaded.getFuelCapacity());
        Assert.assertEquals(expected.getYear(), loaded.getYear());
        Assert.assertEquals(expected.getSeats(), loaded.getSeats());
        Assert.assertEquals(expected.getAssessmentDtos().size(), loaded.getAssessmentDtos().size());
    }
}
