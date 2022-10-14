package com.cerp.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cerp.springboot.model.Student;

  /**
   * spring data JPA internally provides @Repository annotation so we 
   * no need add @Repository annotation in student interface...
   * 
   * By default spring data JPA made JPARepository methods transaction so
   * we no need to add @Transaction annotation in service class...
   * */

public interface StudentRepository extends JpaRepository<Student, Long>{

}
