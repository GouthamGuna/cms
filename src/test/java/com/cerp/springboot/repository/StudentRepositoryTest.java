package com.cerp.springboot.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cerp.springboot.model.Student;

@SpringBootTest
class StudentRepositoryTest {
	
	@Autowired
	private StudentRepository repository;

	@Test
	public void saveStudent() {
		
		Student student=Student.builder()
				.firstName("Jay")
				.lastName("Kumar")
				.mobileno("9876543210")
				.mailId("jay@gmail.com")
				.build();
		
		repository.save(student);
	}

}
