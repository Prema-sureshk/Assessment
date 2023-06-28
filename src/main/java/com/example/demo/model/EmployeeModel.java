package com.example.demo.model;
import lombok.*;

import java.sql.Date;

import org.antlr.v4.runtime.misc.NotNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Past;
@Getter
@Setter
@Builder


public class EmployeeModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private int empid;
  @NotNull
  @Column(name = "name")
	private String name;
  @NotNull
	@Column(name = "designation")
	private String designation;
	
	@Column(name = "phone")
	private String phone;


  
  @Column(name = "dateofbirth")
  @Past
	private Date dateofbirth;
}
