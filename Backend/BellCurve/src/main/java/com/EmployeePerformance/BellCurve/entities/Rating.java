package com.EmployeePerformance.BellCurve.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class Rating {
    @Id
    @Column(length = 1, nullable = false)
    private String ratingId;

    @Column(nullable = false)
    private String ratingCategory;

    public Rating(String ratingId,String ratingCategory){
        this.ratingCategory=ratingCategory;
        this.ratingId=ratingId;
    }
    public Rating(){}

    public String getRatingId() {
        return ratingId;
    }

    public String getRatingCategory() {
        return ratingCategory;
    }
}
