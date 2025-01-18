package com.EmployeePerformance.BellCurve.controllers;

import com.EmployeePerformance.BellCurve.dtos.DistributionDto;
import com.EmployeePerformance.BellCurve.dtos.EmployeeDto;
import com.EmployeePerformance.BellCurve.entities.Distribution;
import com.EmployeePerformance.BellCurve.entities.Employee;
import com.EmployeePerformance.BellCurve.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    @PostMapping("/initializeRatings")
    public void initializeRatings(){
        service.initializeRatings();
    }

    @PostMapping("/addEmployee")
    public ResponseEntity<Employee> addEmployee(@RequestBody EmployeeDto dto){
        Employee employee = service.addEmployee(dto);
        return ResponseEntity.ok(employee);
    }

    @PostMapping("/addDistribution")
    public ResponseEntity<Distribution> addDistribution(@RequestBody DistributionDto dto){
        Distribution distribution=service.addDistribution(dto);
        return ResponseEntity.ok(distribution);
    }

    @DeleteMapping("/flushDistribution")
    public ResponseEntity<String> flushDistribution(){
        service.flushDistribution();
        return ResponseEntity.ok("All Distributions removed!");
    }
    @GetMapping("/bellCurve")
    public ResponseEntity<String> adjustRatings(){
        String out = service.adjustRatings();
        return ResponseEntity.ok(out);
    }
}
