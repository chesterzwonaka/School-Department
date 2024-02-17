package com.chestermabulela.springbootjpaproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.chestermabulela.springbootjpaproject.entity.Department;
import com.chestermabulela.springbootjpaproject.repository.DepartmentRepository;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

   

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long departmentId) {
        try {
            return departmentRepository.getById(departmentId);
        } catch (EntityNotFoundException ex) {
            return null; // or throw a custom exception
        }
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Long id, Department updatedDepartment) {
        Optional<Department> optionalDepDb = departmentRepository.findById(id);

        if (optionalDepDb.isPresent()) {
            Department depDb = optionalDepDb.get();

            // Update the department name if the new name is not null or empty
            if (Objects.nonNull(updatedDepartment.getDepartmentName()) &&
                    !"".equalsIgnoreCase(updatedDepartment.getDepartmentName())) {
                depDb.setDepartmentName(updatedDepartment.getDepartmentName());
            }

            // Update other fields if needed

            // Save the updated department
            return departmentRepository.save(depDb);
        } else {
            // Handle the case where the department with the specified ID is not found
            return null; // or throw a custom exception
        }
    }
}
