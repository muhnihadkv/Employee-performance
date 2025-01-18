package com.EmployeePerformance.BellCurve.repositories;

import com.EmployeePerformance.BellCurve.entities.Distribution;
import com.EmployeePerformance.BellCurve.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DistributionRepository extends JpaRepository<Distribution, Integer> {
    Distribution findByRating(Optional<Rating> byId);
}
