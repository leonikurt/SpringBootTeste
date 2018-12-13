package com.example.FirstSpringData.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.FirstSpringData.entity.Students;
import com.example.FirstSpringData.repository.StudentsRepository;

@RestController
public class StudentsController {
	
	@Autowired
	StudentsRepository studentsRepository;
	
	@RequestMapping(value="/students", method= RequestMethod.GET)
	public List<Students> listStudent(){
		return this.studentsRepository.findAll();
	}
	
	@RequestMapping(value="/students", method= RequestMethod.POST)
	public Students saveStudent(@RequestBody Students students) {
		return this.studentsRepository.save(students);
	}
	
	@RequestMapping(value="/students/{id}", method= RequestMethod.GET)
	public Students findById(@PathVariable String id) {
		return this.studentsRepository.findOne(id);
	}
	
	@RequestMapping(value="/students/{name}/name", method= RequestMethod.GET)
	public List<Students> findByName(@PathVariable String name){
		return this.studentsRepository.findByNameLikeIgnoreCase(name);
	}
	
	
	@RequestMapping(value="/students/{name}/name", method= RequestMethod.DELETE)
	public void deleteStudent(@PathVariable String name){
		List<Students> students = this.studentsRepository.findByNameLikeIgnoreCase(name);
		this.studentsRepository.delete(students);
	}
	
}
