package com.cerp.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cerp.springboot.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
