package com.cerp.springboot.service.Impl;

import org.springframework.stereotype.Service;

import com.cerp.springboot.model.Student;
import com.cerp.springboot.repository.StudentRepository;
import com.cerp.springboot.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	private StudentRepository studentrepository;
	
	public StudentServiceImpl(StudentRepository studentrepository) {
		super();
		this.studentrepository = studentrepository;
	}

	@Override
	public Student saveStudent(Student student) {
		return studentrepository.save(student);
	}

}
