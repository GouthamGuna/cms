package com.cerp.springboot.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cerp.springboot.exception.ResourceNotFound;
import com.cerp.springboot.model.Student;
import com.cerp.springboot.repository.StudentRepository;
import com.cerp.springboot.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	
	/**
	 *  Two type of Dependency Injection 
	 *  	Setter_based //option parameter
	 *  	*Constructor_based // all parameter monetary
	 **/
	
	private StudentRepository studentrepository;
	
	/**
	 * 	Staring with Spring 4,3 if a class which is configured 
	 *  spring bean, has only one constructor the @Autowired annotation can be
	 *  omitted and spring will use the constructor and inject all necessary dependencies
	 * */
	
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
	public Student getStudentById(long id) {
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
	public Student updateStudent(Student student, long id) {
		
		//we need to check whether student with given Id is exist in DB or not
		Student exitingstudent = studentrepository.findById(id).orElseThrow(
				()-> new ResourceNotFound("student", "Id", "id"));
		
		exitingstudent.setFirstName(student.getFirstName());
		exitingstudent.setLastName(student.getLastName());
		exitingstudent.setMailId(student.getMailId());
		exitingstudent.setMobileno(student.getMobileno());
		
		//save exiting student to DB
		studentrepository.save(exitingstudent);
			
		return exitingstudent;
	}

	@Override
	public void deleteStudent(long id) {
		
		//check whether student exist in a DB or not
		studentrepository.findById(id).orElseThrow(
				()-> new ResourceNotFound("student", "Id", id));
		studentrepository.deleteById(id);
	}

}
