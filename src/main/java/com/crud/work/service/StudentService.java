package com.crud.work.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 

import com.crud.work.entity.Student;
import com.crud.work.repository.StudentRepo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StudentService {

	@Autowired
	private StudentRepo repo;
	
	
	
	public List<Student> getallStudents(){
		return repo.findAll();
		
	}
	
	public Student createStudent(Student ss) {
		return repo.save(ss);
	}
	
	
	
	public Student findByID(Long id) {
		return repo.findById(id).orElseThrow(() -> new RuntimeException("Error Student not Found"));
	}
	
	public String deleteStudent(Long id) {
		 repo.deleteById(id);
		 return "Student Deleted Successfully";
	}
	
	public Student updateStudent( Student ee , Long id ) {
		return repo.findById(id).map((s) ->{
			s.setName(ee.getName());
			s.setAge(ee.getAge());
			return repo.save(s); 
			}).orElseThrow( ()-> new IllegalArgumentException("Student Not FOUND"));
		}
	
}
