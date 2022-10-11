package com.cerp.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="first_name", nullable = false)
	private String firstname;
	
	@Column(name="last_name", nullable = false)
	private String lastname;
	
	@Column(name="mailId", nullable = false)
	private String mailId;
	
	@Column(name="mobileno", nullable = false)
	private String mobileno;

}
