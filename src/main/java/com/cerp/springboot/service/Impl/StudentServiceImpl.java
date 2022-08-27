package com.cerp.springboot.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cerp.springboot.exception.ResourceNotFound;
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

	@Override
	public List<Student> getAllStudent() {
		return studentrepository.findAll();
	}

	@Override
	public Student getStudentById(int id) {
		/*
		 * Optional<Student> student = studentrepository.findById(id);
		 * 
		 * if(student.isPresent()) { return student.get(); }else { throw new
		 * ResourceNotFound("student", "Id", id); }
		 */
		
		//by using lambda expression
		return studentrepository.findById(id).orElseThrow(()-> 
		new ResourceNotFound("student", "Id", id));
	}

	@Override
	public Student updateStudent(Student student, int id) {
		
		//we need to check whether student with given Id is exist in DB or not
		Student exitingstudent = studentrepository.findById(id).orElseThrow(
				()-> new ResourceNotFound("student", "Id", "id"));
		
		exitingstudent.setFirstname(student.getFirstname());
		exitingstudent.setLastname(student.getLastname());
		exitingstudent.setMailId(student.getMailId());
		exitingstudent.setMobileno(student.getMobileno());
		
		//save exiting student to DB
		studentrepository.save(exitingstudent);
			
		return exitingstudent;
	}

}
