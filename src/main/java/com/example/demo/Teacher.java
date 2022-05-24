package com.example.demo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection  = "teacher")
public class Teacher {
    @Id
	private String name;
	private String image;
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		String i="\\assets\\images\\";
		this.image = i+image;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Teacher [name=" + name + ", image=" + image + "]";
	}
	
	
	
}
