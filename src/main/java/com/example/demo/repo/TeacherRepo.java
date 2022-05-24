package com.example.demo.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.Teacher;

public interface TeacherRepo extends MongoRepository<Teacher,String> {

	Teacher findByName(String name);

	void deleteByName(String name);

}
