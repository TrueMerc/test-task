package com.mcb.creditfactory.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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

    @Column(name = "fuel_capacity")
    private Integer fuelCapacity;
    @Column(name="year_of_issue")
    private Short year;
    private Short seats;

    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(name = "AIRPLANES_ASSESSMENTS",
        joinColumns = @JoinColumn(name = "airplane_id"),
        inverseJoinColumns = @JoinColumn(name = "assessment_id")
    )
    @OrderBy("date_time DESC")
    private List<Assessment> assessments;
}
