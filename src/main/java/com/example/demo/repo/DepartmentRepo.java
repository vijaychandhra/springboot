package com.example.demo.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.Department;
import com.example.demo.Teacher;


public interface DepartmentRepo extends MongoRepository<Department, Integer> {

	Department findByName(String name);

}
