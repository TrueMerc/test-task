package com.mcb.creditfactory.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "AIRPLANE")
public class Airplane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String model;
    private String manufacturer;
    private Integer fuelCapacity;
    @Column(name="year_of_issue")
    private Short year;
    private Short seats;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "AIRPLANES_ASSESSMENT",
        joinColumns = @JoinColumn(name = "airplane_id"),
        inverseJoinColumns = @JoinColumn(name = "assessment_id")
    )
    private Collection<Assessment> assessments;
}