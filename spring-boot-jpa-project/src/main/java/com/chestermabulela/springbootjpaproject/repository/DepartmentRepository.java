package com.chestermabulela.springbootjpaproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chestermabulela.springbootjpaproject.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
