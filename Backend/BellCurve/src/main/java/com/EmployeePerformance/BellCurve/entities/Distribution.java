package com.EmployeePerformance.BellCurve.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Distribution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int distributionId;

    @OneToOne
    @JoinColumn(name = "ratingId", referencedColumnName = "ratingId", nullable = false)
    private Rating rating;

    @Column(nullable = false)
    private double standard;

    private double actual;

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public void setStandard(double standard) {
        this.standard = standard;
    }

    public void setActual(double actual) {
        this.actual = actual;
    }

    public int getDistributionId() {
        return distributionId;
    }

    public Rating getRating() {
        return rating;
    }

    public double getStandard() {
        return standard;
    }

    public double getActual() {
        return actual;
    }

    public Distribution(){}
}
