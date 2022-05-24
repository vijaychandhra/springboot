package com.example.demo;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection  = "college")
public class College {
    @Id
	private int id;
	private String name;
	//@Field(value = "department")
	private List<Department> d;
	
	public List<Department> getD() {
		return d;
	}
	public void setD(List<Department> d) {
		this.d = d;
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
		return "Vijay [id=" + id + ", name=" + name + ", d=" + d + "]";
	}
	
	
	
}
