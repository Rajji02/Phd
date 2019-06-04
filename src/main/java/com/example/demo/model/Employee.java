package com.example.demo.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
@Entity
@Table(name="emp")
@IdClass( EmployeeKeys.class )
public class Employee {

	@Id
	private int eid;
	@Id
	private int aid;
	
}
