package com.example.FirstSpringData.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.FirstSpringData.entity.Students;

public interface StudentsRepository extends MongoRepository<Students, String> {
	 public List<Students> findByNameLikeIgnoreCase(String name);
}