package com.scenerio.emp.test;

import org.junit.jupiter.api.Test;
import com.scenerio.emp.service.*;

import static org.junit.jupiter.api.Assertions.*;

public class EmpWageServiceTest {

    @Test
    void testValidCompany(){
        assertTrue(EmpWageValidator.validateCompany("Service now"));
    }

    @Test
    void testInvalidCompany(){
        assertFalse(EmpWageValidator.validateCompany("sn123"));
    }

    @Test
    void testAddCompany(){
        IComputeEmpWageService service = new EmpWageServiceImpl();
        service.addCompanyEmpWage("Dafodil",20,20,100);
        assertNotEquals(-1, service.getTotalWage("Dafodil"));
    }
}
