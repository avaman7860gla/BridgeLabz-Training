package com.scenerio.emp.service;

import com.scenerio.emp.model.*;
import com.scenerio.emp.repository.*;

import java.util.*;

public class EmpWageServiceImpl implements IComputeEmpWageService {

    private EmpWageRepository repository = new EmpWageRepositoryImpl();

    // UC8 Add multiple companies with REGEX validation
    public void addCompanyEmpWage(String companyName, int wagePerHour, int maxWorkingDays, int maxWorkingHours){
        if(!EmpWageValidator.validateCompany(companyName)) {
        	throw new IllegalArgumentException("Invalid Company Name");
        }
        if(!EmpWageValidator.validateNumber(wagePerHour)) {
        	throw new IllegalArgumentException("Invalid Wage");
        }
        repository.save(new CompanyEmpWage(companyName, wagePerHour, maxWorkingDays, maxWorkingHours));
    }

    // UC1–UC13 Wage Computation
    public void computeWage(){
        for(CompanyEmpWage company : repository.findAll()){
            int totalHours = 0;
            int totalDays =0;
            List<Integer> dailyWages = new ArrayList<>();
            while(totalHours <company.getMaxWorkingHours() && totalDays<company.getMaxWorkingDays()){
                totalDays++;
                int empCheck = (int)(Math.random()*3); // UC1
                int workHours = 0;
                switch(empCheck){ // UC4
                    case 1: 
                    	workHours= 4; 
                    	break;  
                    case 2: 
                    	workHours = 8; 
                    	break;  
                    default: 
                    	workHours =0;
                }
                int dailyWage = workHours *company.getWagePerHour();  // UC2
                totalHours+= workHours;                              // UC6
                dailyWages.add(dailyWage);                            // UC13
            }
            int totalWage = totalHours * company.getWagePerHour();     // UC5
            company.setTotalEmpWage(totalWage);                        // UC9

            System.out.println(company);
            System.out.println("Daily Wages: " +dailyWages);
            System.out.println();
        }
    }

    // UC14 Query wage
    public int getTotalWage(String companyName){
        CompanyEmpWage company =repository.findByName(companyName);
        return (company != null) ? company.getTotalEmpWage() : -1;
    }
}
