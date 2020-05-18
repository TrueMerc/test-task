package com.mcb.creditfactory.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CAR")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String model;
    private Double power;
    @Column(name = "year_of_issue")
    private Short year;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "CARS_ASSESMENTS",
        joinColumns = @JoinColumn(name = "car_id"),
        inverseJoinColumns = @JoinColumn(name = "assessment_id")
    )
    @OrderBy("date_time DESC")
    private List<Assessment> assessments;
}
