package com.scenerio.emp.presentation;

import com.scenerio.emp.service.*;

public class EmployeeWageMain {

    public static void main(String[] args){

        System.out.println("Welcome to employee wage computation program");
        IComputeEmpWageService service = new EmpWageServiceImpl();

        // UC8 Multiple Companies
        service.addCompanyEmpWage("Service now",20,20,100);
        service.addCompanyEmpWage("MAQ Software",25,22,120);
        service.addCompanyEmpWage("Dafodil",18,24,110);

        // Compute
        service.computeWage();

        // UC14 Query
        System.out.println("\nQueried wage of Service now: " + service.getTotalWage("Service now"));
    }
}
