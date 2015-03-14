package com.uk.security.dao;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "user")
public class User {

	@Id
	private String id;
	@Field
	private String name;
	@Field
	private String surname;
	@Field
	private int age;
	@Field
	private String username;
	@Field
	private String password;
	@Field
	private int role;
	
	public User(String name, String surname, int age, String username, String password, int role) {
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.username = username;
		this.password = password;
		this.role = role;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}
}
