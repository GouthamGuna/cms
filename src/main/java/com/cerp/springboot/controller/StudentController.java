package com.cerp.springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cerp.springboot.model.Student;
import com.cerp.springboot.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {
	
	private StudentService studentservice;

	public StudentController(StudentService studentservice) {
		super();
		this.studentservice = studentservice;
	}
	
	@PostMapping
	public ResponseEntity<Student> savestudent(@RequestBody Student student){
		return new ResponseEntity<Student>(studentservice.saveStudent(student), HttpStatus.CREATED);
	}

}
