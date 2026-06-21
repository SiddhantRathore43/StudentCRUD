package com.crud.work.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.work.entity.Employee;
import com.crud.work.enums.Department;

public interface EmpRepo extends JpaRepository<Employee,Long> {
	 List<Employee> findByDepartment(Department department);
}
