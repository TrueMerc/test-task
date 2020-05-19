package com.mcb.creditfactory.services.airplane;

import com.mcb.creditfactory.dto.AirplaneDto;
import com.mcb.creditfactory.external.ExternalApproveService;
import com.mcb.creditfactory.entities.Airplane;
import com.mcb.creditfactory.repositories.AirplaneRepository;
import com.mcb.creditfactory.services.assessment.AssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Provides airplane service implementation.
 */
@Service
public class AirplaneServiceImpl implements AirplaneService {
    @Autowired
    private ExternalApproveService approveService;

    @Autowired
    private AirplaneRepository airplaneRepository;

    @Autowired
    private AssessmentService assessmentService;

    @Override
    public boolean approve(AirplaneDto dto) {
        return approveService.approve(new AirplaneAdapter(dto)) == 0;
    }

    @Override
    public Airplane save(Airplane airplane) {
        return airplaneRepository.save(airplane);
    }

    @Override
    public Optional<Airplane> load(Long id) {
        return airplaneRepository.findById(id);
    }

    @Override
    public Airplane fromDto(AirplaneDto dto) {
        return new Airplane(
                dto.getId(),
                dto.getBrand(),
                dto.getModel(),
                dto.getManufacturer(),
                dto.getFuelCapacity(),
                dto.getYear(),
                dto.getSeats(),
                dto.getAssessmentDtos() != null ?
                        dto.getAssessmentDtos().stream().map(assessmentDto -> assessmentService.fromDto(assessmentDto))
                                .collect(Collectors.toList()) : null
        );
    }

    @Override
    public AirplaneDto toDTO(Airplane airplane) {
        return new AirplaneDto(
                airplane.getId(),
                airplane.getBrand(),
                airplane.getModel(),
                airplane.getManufacturer(),
                airplane.getFuelCapacity(),
                airplane.getYear(),
                airplane.getSeats(),
                airplane.getAssessments() != null ?
                        airplane.getAssessments().stream().map(assessment -> assessmentService.toDto(assessment))
                                .collect(Collectors.toList()) : null
        );
    }

    @Override
    public Long getId(Airplane airplane) {
        return airplane.getId();
    }
}
