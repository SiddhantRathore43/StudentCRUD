package com.crud.work.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.work.entity.Employee;
import com.crud.work.enums.Department;

@Repository
public interface EmpRepo extends JpaRepository<Employee,Long> {
	
	 List<Employee> findByDepartment(Department department);
	 
	 List<Employee> findAllByOrderBySalaryDesc();
	 
	 List<Employee> findAllByOrderBySalaryAsc();

}
