package com.collegeFest.Debate.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int studentId;
	
	@Column
	private String firstName;
	
	@Column
	private String lastName;
	
	@Column
	private String course;
	
	@Column
	private String country;

}
