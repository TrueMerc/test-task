package com.mcb.creditfactory.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssessmentDto {
    private Long id;
    private LocalDateTime dateTime;
    BigDecimal value;
}
