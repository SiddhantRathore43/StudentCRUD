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

import com.crud.work.entity.Student;
import com.crud.work.service.StudentService;

@RestController
@RequestMapping("/Student") 
public class StudentController {

	@Autowired
	private StudentService service;
	
	
	@GetMapping
	public List<Student> getAll(){
		return service.getallStudents();
	}
	
	
	@GetMapping("/{id}")
	public Student getByID(@PathVariable Long id) {
		return service.findByID(id);
	}
	
	@PostMapping
	public Student createStudent(@RequestBody Student ss ) {
		
		return service.createStudent(ss);
	}
	
	@DeleteMapping("/{id}")
	public String deleteById(@PathVariable Long id) {
		 service.deleteStudent(id);
		 return "Student Deleted";
	}
	
	@PutMapping("/{id}")
	
	public Student updateStudent(@RequestBody Student ss, @PathVariable Long id) {
		return service.updateStudent(ss, id);
	}
}
