package com.mcb.creditfactory.service.assessment;

import com.mcb.creditfactory.dto.AssessmentDto;
import com.mcb.creditfactory.model.Assessment;
import org.springframework.stereotype.Service;

@Service
public class AssessmentServiceImpl implements AssessmentService {

    @Override
    public Assessment fromDto(AssessmentDto assessmentDto) {
        return new Assessment(
                assessmentDto.getId(),
                assessmentDto.getDateTime(),
                assessmentDto.getValue()
        );
    }

    @Override
    public AssessmentDto toDto(Assessment assessment) {
        return new AssessmentDto(
                assessment.getId(),
                assessment.getDateTime(),
                assessment.getValue()
        );
    }
}
