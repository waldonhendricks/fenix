package co.uk.mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "Person")
public class Person {
	@Id
	private String id;
	@Field
	private String name;
	@Field
	private String address;

	public Person() {
	}

	public Person(String i, String n, String a) {
		this.id = i;
		this.name = n;
		this.address = a;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return id + "::" + name + "::" + address;
	}
}
