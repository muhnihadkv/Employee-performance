package com.EmployeePerformance.BellCurve.services;

import com.EmployeePerformance.BellCurve.dtos.DistributionDto;
import com.EmployeePerformance.BellCurve.dtos.EmployeeDto;
import com.EmployeePerformance.BellCurve.entities.Distribution;
import com.EmployeePerformance.BellCurve.entities.Employee;
import com.EmployeePerformance.BellCurve.entities.Rating;
import com.EmployeePerformance.BellCurve.repositories.DistributionRepository;
import com.EmployeePerformance.BellCurve.repositories.EmployeeRepository;
import com.EmployeePerformance.BellCurve.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DistributionRepository distributionRepository;

    public void initializeRatings(){
        long count = ratingRepository.count();
        if(count==0){
            List<Rating> defaultRatings = List.of(
                    new Rating("A","Outstanding"),
                    new Rating("B","Very Good"),
                    new Rating("C","Good"),
                    new Rating("D","Need to Improve"),
                    new Rating("E","Low Performers")
            );
            ratingRepository.saveAll(defaultRatings);
        }
    }

    public Employee addEmployee(EmployeeDto dto) {
        Employee employee = new Employee();
        employee.setName(dto.getName());
        employee.setRating(ratingRepository.findById(dto.getRating()).orElse(null));
        employeeRepository.save(employee);

        return employee;
    }

    public Distribution addDistribution(DistributionDto dto) {
        Distribution distribution = new Distribution();
        distribution.setRating(ratingRepository.findById(dto.getRating()).orElse(null));
        distribution.setStandard(dto.getStandard());
        distribution.setActual(findActual(dto.getRating()));
        distributionRepository.save(distribution);
        return distribution;
    }

    public double findActual(String rating) {
        int count = employeeRepository.countByRating_RatingId(rating);
        long total = employeeRepository.count();
        double percentage = (double) (count * 100L) / total;
        return Double.parseDouble(String.format("%.2f", percentage));
    }

    public void flushDistribution() {
        distributionRepository.deleteAll();
    }

    public String adjustRatings(){
        List<Distribution> distributions = distributionRepository.findAll();
        List<Employee> employees = employeeRepository.findAll();
        List<String> PosDevs = new ArrayList<>();
        List<String> NegDevs = new ArrayList<>();
        for (Distribution distribution: distributions){
            if (distribution.getActual()>=distribution.getStandard()){
                PosDevs.add(distribution.getRating().getRatingId());
            }
            else if (distribution.getActual()<=distribution.getStandard()){
                NegDevs.add(distribution.getRating().getRatingId());
            }
        }
        StringBuilder out = new StringBuilder();

        for (String PosDev : PosDevs) {
            for (String NegDev : NegDevs) {
                for (Employee employee : employees) {
                    if (employee.getRating().getRatingId().equals(PosDev) && canMoveDown(PosDev,NegDev)) {
                        out.append("Moving ")
                                .append(employee.getName())
                                .append(" from ")
                                .append(PosDev)
                                .append(" to ")
                                .append(NegDev)
                                .append("\n");
                        employee.setRating(ratingRepository.findById(NegDev).orElse(null));
                        for (Distribution distribution: distributions){
                            distribution.setActual(findActual(distribution.getRating().getRatingId()));
                        }

                        break;
                    }
                }
            }
        }
        return out.toString();
    }

    private boolean canMoveDown(String PosDev, String NegDev) {
        Distribution PosDis = distributionRepository.findByRating(ratingRepository.findById(PosDev));
        Distribution NegDis = distributionRepository.findByRating(ratingRepository.findById(NegDev));
        return (PosDis.getActual() > PosDis.getStandard()) && (NegDis.getActual() < NegDis.getStandard());
    }

}