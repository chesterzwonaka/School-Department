package com.chestermabulela.springbootjpaproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chestermabulela.springbootjpaproject.entity.Department;

@Service
public class OtherService {
	
	@Autowired
    private DepartmentService departmentService;

    public void insertNewDepartment() {
        // Create a new Department entity
        Department newDepartment = new Department();
        newDepartment.setDepartmentName("New Department");
        newDepartment.setDepartmentAddress("New Department Address");
        newDepartment.setDepartmentCode("New Department Code");

        // Save the new department to the database
        Department savedDepartment = departmentService.saveDepartment(newDepartment);

        // You can use the savedDepartment if needed
        System.out.println("New Department saved with ID: " + savedDepartment.getDepartmentId());
    }

}
