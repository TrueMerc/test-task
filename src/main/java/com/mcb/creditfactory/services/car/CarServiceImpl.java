package com.mcb.creditfactory.service.car;

import com.mcb.creditfactory.dto.CarDto;
import com.mcb.creditfactory.external.ExternalApproveService;
import com.mcb.creditfactory.entities.Car;
import com.mcb.creditfactory.repository.AssessmentRepository;
import com.mcb.creditfactory.repository.CarRepository;
import com.mcb.creditfactory.service.assessment.AssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private ExternalApproveService approveService;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private AssessmentService assessmentService;

    @Autowired
    private AssessmentRepository assessmentRepository;

    @Override
    public boolean approve(CarDto dto) {
        return approveService.approve(new CarAdapter(dto)) == 0;
    }

    @Override
    public Car save(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Optional<Car> load(Long id) {
        return carRepository.findById(id);
    }

    @Override
    public Car fromDto(CarDto dto) {
        return new Car(
                null,
                dto.getBrand(),
                dto.getModel(),
                dto.getPower(),
                dto.getYear(),
                dto.getAssessmentDtos() != null ?
                dto.getAssessmentDtos().stream()
                        .map(assessmentDto -> assessmentService.fromDto(assessmentDto)).collect(Collectors.toList()):
                        null
         );
    }

    @Override
    public CarDto toDTO(Car car) {
        return new CarDto(
                car.getBrand(),
                car.getModel(),
                car.getPower(),
                car.getYear(),
                car.getAssessments().stream()
                        .map(assessment -> assessmentService.toDto(assessment)).collect(Collectors.toList())
        );
    }

    @Override
    public Long getId(Car car) {
        return car.getId();
    }
}
