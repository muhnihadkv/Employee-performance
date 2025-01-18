package com.EmployeePerformance.BellCurve.repositories;

import com.EmployeePerformance.BellCurve.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    int countByRating_RatingId(String rating);
}
