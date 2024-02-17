package com.chestermabulela.springbootjpaproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chestermabulela.springbootjpaproject.entity.Department;
import com.chestermabulela.springbootjpaproject.service.DepartmentService;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping(value = "/departments",produces = "application/json")
	@ResponseBody
	public Department saveDepartment(@RequestBody Department department)
	{
		return departmentService.saveDepartment(department);
	}
	
	@GetMapping("/departments")
	@ResponseBody
	public List<Department> fetchDepartment( )
	{
		return departmentService.fetchDepartment();
	}
	
	@GetMapping("/departments/{id}")
	public Department fetchDepartmentById(@PathVariable("id") Long departmentId)
	{
		return departmentService.fetchDepartmentById(departmentId);
	}
	
	@DeleteMapping("/departments/{id}")
	public String deleteDepartmentById(@PathVariable("id") Long departmentId)
	{
		departmentService.deleteDepartmentById(departmentId);
		return "Department deleted successfully";
	}
	
	@PutMapping("/departments/{id}")
	public Department updateDepartment(@PathVariable Long id, @RequestBody Department department) {
		//TODO: process PUT request
		
		return departmentService.updateDepartment(id, department);
	}
}
