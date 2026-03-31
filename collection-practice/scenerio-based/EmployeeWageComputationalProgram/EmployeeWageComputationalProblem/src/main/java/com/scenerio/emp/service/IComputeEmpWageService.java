package com.scenerio.emp.service;

public interface IComputeEmpWageService {
    void addCompanyEmpWage(String companyName, int wagePerHour, int maxWorkingDays, int maxWorkingHours);
    void computeWage();
    int getTotalWage(String companyName);
}
