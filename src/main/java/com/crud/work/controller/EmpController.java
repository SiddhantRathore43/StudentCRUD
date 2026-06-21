package com.crud.work.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.work.entity.Employee;
import com.crud.work.enums.Department;
import com.crud.work.service.EmpService;


@RestController
@RequestMapping("Employees")
public class EmpController {

	@Autowired
	private EmpService service;
	
	@GetMapping
	public List<Employee> getAll(){
		return service.getAllEMp();
	}
	
	@GetMapping("/department/{department}")
	public List<Employee> getByDepartment(
	        @PathVariable Department department) {

	    return service.getByDepartment(department);
	}
	
	@GetMapping("/{id}")
	public Employee findEbyId(@PathVariable Long id) {
		return service.getEmpById(id);
	}
	
	@PutMapping("/{id}")
	public Employee updateEmp(@RequestBody Employee ee,@PathVariable Long id) {
		return service.updateEmployee(ee, id);
	}
	
	@PostMapping
	public Employee createEmp(@RequestBody Employee ee) {
		return service.createEmployee(ee);
	}
	
	@DeleteMapping
	public void DelEmployee(@PathVariable Long id) {
		service.DelEmp(id);
	}
}

