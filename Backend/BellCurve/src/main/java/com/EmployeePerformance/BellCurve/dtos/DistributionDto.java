package com.EmployeePerformance.BellCurve.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
@AllArgsConstructor
@NoArgsConstructor
public class DistributionDto {
    private String rating;
    private double standard;

    public double getStandard() {
        return standard;
    }

    public String getRating() {
        return rating;
    }
}
