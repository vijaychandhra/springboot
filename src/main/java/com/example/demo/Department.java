package com.example.demo;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
@Document(collection  = "dept")
public class Department {
	@Id
	private int id;
	private String name;
	@Field(value = "teacher")
	private List<Teacher> b;
	
	
	public List<Teacher> getB() {
		return b;
	}
	public void setB(List<Teacher> b) {
		this.b = b;
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
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", b=" + b + "]";
	}
	
	
}
