package com.EmployeePerformance.BellCurve.dtos;

import com.EmployeePerformance.BellCurve.entities.Rating;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private String name;
    private String rating;

    public String getName() {
        return name;
    }

    public String getRating() {
        return rating;
    }
}
