package com.cerp.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="student_registration")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="first_name", nullable = false)
	private String firstname;
	
	@Column(name="last_name", nullable = false)
	private String lastname;
	
	@Column(unique=true)
	private String mailId;
	
	@Column(unique=true)
	private String mobileno;

}
