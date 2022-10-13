package com.cerp.springboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cerp.springboot.model.Student;
import com.cerp.springboot.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	private StudentService studentservice;

	public StudentController(StudentService studentservice) {
		super();
		this.studentservice = studentservice;
	}
	
	//build create student REST API
	@PostMapping("/studentsregister")
	public ResponseEntity<Student> savestudent(@RequestBody Student student){
		System.out.println("Inside the Method...");
		return new ResponseEntity<Student>(studentservice.saveStudent(student), HttpStatus.CREATED);
	}

	//build get all student REST API
	@GetMapping("/allstudentlist")
	public List<Student> getAllStudents(){
		return studentservice.getAllStudent();
	}
	
	//build get student by Id REST API
	//http://localhost:8080/api/student/id 
	@GetMapping("/students/{id}") //path variable is dynamic
	public ResponseEntity<Student> getStudedentId(@PathVariable("id") int studentId){
		return new ResponseEntity<Student>(studentservice.getStudentById(studentId), HttpStatus.OK);
	}
	
	//build update student REST API
	@PutMapping("/students/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable("id") int studentId
			,@RequestBody Student student){
		return new ResponseEntity<Student>(studentservice.updateStudent(student, studentId), HttpStatus.OK);
	}
	
	//build delete student REST API
	@DeleteMapping("/students/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId){
		//delete student
		studentservice.deleteStudent(studentId);
		
		return new ResponseEntity<String>("Student Deleted Successfully...", HttpStatus.OK);
	}
}
