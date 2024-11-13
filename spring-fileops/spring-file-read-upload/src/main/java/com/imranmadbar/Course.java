package com.imranmadbar;

import java.time.LocalDate;

public class Course {

	private int id;
	private String name;
	private int number;

	public Course() {
		// TODO Auto-generated constructor stub
	}

	public Course(int i, String string, int j) {
		// TODO Auto-generated constructor stub
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


	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", number=" + number + "]";
	}
	
	
	

}