package com.crud.work.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.work.entity.Employee;
import com.crud.work.enums.Department;
import com.crud.work.repository.EmpRepo;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class EmpService {

	@Autowired
	private EmpRepo repo;
	
	
	public List<Employee> getAllEMp(){
		return repo.findAll();
	}
	
	public Employee getEmpById(Long id) {
		return repo.findById(id).orElseThrow(() -> new RuntimeException("Error Employee not found"));
	}
	
	public Employee updateEmployee(Employee ee, Long id) {
			return repo.findById(id).map((e) ->{
				e.setName(ee.getName());
				e.setAge(ee.getAge());
				e.setSalary(ee.getSalary());
				e.setDepartment(ee.getDepartment());
				return repo.save(e); 
				}).orElseThrow( ()-> new IllegalArgumentException("employee Not FOUND"));
			}
	
	public Employee createEmployee(Employee ee) {
		return repo.save(ee);
	}
	
	public void DelEmp(Long id) {
		repo.deleteById(id);
	}
	
	public List<Employee> getByDepartment(Department department) {
	    return repo.findByDepartment(department);
	}
	
	public List<Employee> sortBySalaryDesc(){
		return repo.findAllByOrderBySalaryDesc();
	}
	
	public List<Employee> sortBySalaryAsc(){
		return repo.findAllByOrderBySalaryAsc();
	}
	
 
	
}
