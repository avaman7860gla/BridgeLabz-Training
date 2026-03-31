package com.scenerio.emp.model;

public class CompanyEmpWage {

    private String companyName;
    private int wagePerHour;
    private int maxWorkingDays;
    private int maxWorkingHours;
    private int totalEmpWage;

    // Constructor
    public CompanyEmpWage(String companyName, int wagePerHour, int maxWorkingDays, int maxWorkingHours){
        this.companyName=companyName;
        this.wagePerHour =wagePerHour;
        this.maxWorkingDays =maxWorkingDays;
        this.maxWorkingHours =maxWorkingHours;
    }

    // Getters and setter
    public String getCompanyName() { 
    	return companyName; 
    }
    public int getWagePerHour() { 
    	return wagePerHour; 
    }
    public int getMaxWorkingDays() { 
    	return maxWorkingDays; 
    }
    public int getMaxWorkingHours() { 
    	return maxWorkingHours; 
    }
    public int getTotalEmpWage() { 
    	return totalEmpWage; 
    }
    public void setTotalEmpWage(int totalEmpWage){
        this.totalEmpWage = totalEmpWage;
    }

    // Override toString method
    @Override
    public String toString(){
        return "Company: " + companyName + " | Total Wage: " + totalEmpWage;
    }
}
