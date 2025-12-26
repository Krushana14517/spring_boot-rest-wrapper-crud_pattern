package com.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud.model.StudentModel;
import com.crud.serivce.StudetnService;

@RestController
public class StudentController {

	@Autowired
	StudetnService studser;
	
	@GetMapping("/get")
	public ResponseEntity<?> getstudent()
	{
		return studser.get();
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> addStudent( @Validated @RequestBody StudentModel ref)
	{
		return studser.add(ref);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateStudent(@PathVariable int id , @Validated @RequestBody StudentModel ref)
	{
		return studser.update( id, ref);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteStudent(@PathVariable int id )
	{
		return studser.delete(id);
	}
	
}
