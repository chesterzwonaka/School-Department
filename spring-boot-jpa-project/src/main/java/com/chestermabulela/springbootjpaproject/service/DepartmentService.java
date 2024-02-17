package com.chestermabulela.springbootjpaproject.service;

import java.util.List;

import com.chestermabulela.springbootjpaproject.entity.Department;

public interface DepartmentService {

	public Department saveDepartment(Department department);

	public List<Department> fetchDepartment();

	public Department fetchDepartmentById(Long departmentId);

	public void deleteDepartmentById(Long departmentId);

	public Department updateDepartment(Long id, Department department);

}
