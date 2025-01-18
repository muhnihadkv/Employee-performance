package com.EmployeePerformance.BellCurve.repositories;

import com.EmployeePerformance.BellCurve.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends JpaRepository<Rating,String> {
}
