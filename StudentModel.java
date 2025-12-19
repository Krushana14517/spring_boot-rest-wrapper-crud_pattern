package com.crud.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

public class StudentModel {
	
	private int id;
	@Size(min=2,message="enter first letter moew than two letter.")
	private String name;
	private String lname;
	@Min(value = 18,message="age should be more than 18.")
	private int age;
	
	public StudentModel(int id, String name, String lname, int age) {
		
		this.id = id;
		this.name = name;
		this.lname = lname;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	

}
