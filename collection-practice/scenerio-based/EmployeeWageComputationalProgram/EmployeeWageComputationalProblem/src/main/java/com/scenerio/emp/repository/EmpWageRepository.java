package com.scenerio.emp.repository;

import com.scenerio.emp.model.*;
import java.util.List;

public interface EmpWageRepository {
    void save(CompanyEmpWage company);
    List<CompanyEmpWage> findAll();
    CompanyEmpWage findByName(String name);
}
