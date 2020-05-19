package com.mcb.creditfactory.services.assessment;

import com.mcb.creditfactory.dto.AssessmentDto;
import com.mcb.creditfactory.entities.Assessment;

public interface AssessmentService {
    Assessment fromDto(AssessmentDto assessmentDto);

    AssessmentDto toDto(Assessment assessment);
}
