package com.scenerio.emp.repository;

import com.scenerio.emp.model.*;
import java.util.*;

public class EmpWageRepositoryImpl implements EmpWageRepository {

    private List<CompanyEmpWage> companyList = new ArrayList<>();

    // Method to save company in a list
    public void save(CompanyEmpWage company){
        companyList.add(company);
    }

    // Method to find all company
    public List<CompanyEmpWage> findAll(){
        return companyList;
    }

    // Method to find company employee wage by name
    public CompanyEmpWage findByName(String name){
        for(CompanyEmpWage c : companyList){
            if(c.getCompanyName().equalsIgnoreCase(name))
                return c;
        }
        return null;
    }
}
