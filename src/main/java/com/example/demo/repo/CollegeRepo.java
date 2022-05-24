package com.example.demo.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.College;


public interface CollegeRepo extends MongoRepository<College, Integer> {

}
