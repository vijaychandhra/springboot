package com.example.demo.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.User;

public interface UserRepo extends MongoRepository<User, String> {

	User findByName(String name);

}
