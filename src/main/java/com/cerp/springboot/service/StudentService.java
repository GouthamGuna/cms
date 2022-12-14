package com.cerp.springboot.service;

import java.util.List;

import com.cerp.springboot.model.Student;

public interface StudentService {
	
	Student saveStudent(Student student);
	List<Student> getAllStudent();
	Student getStudentById(long id);
	Student updateStudent(Student student, long id);
	void deleteStudent(long id);

}
