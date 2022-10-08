package com.piseth.java.school.model;

import java.sql.Array;

public class Person2 {
	private String name;
	private String gender;
	private int age;
	private Array pets;

	public Person2(String name, String gender, int age, Array pets) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.pets = pets;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", gender=" + gender + ", age=" + age + ", pets=" + pets + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Array getPets() {
		return pets;
	}

	public void setPets(Array pets) {
		this.pets = pets;
	}

}
