package com.webservice.model;

import javax.ws.rs.Produces;
import javax.xml.bind.annotation.XmlRootElement;
@Produces("application/json")
@XmlRootElement(name = "person")
public class Person {
	private String name;
	private int age;
	private int id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return id + "::" + name + "::" + age;
	}

}
