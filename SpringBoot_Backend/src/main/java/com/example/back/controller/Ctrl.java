package com.example.back.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.back.exception.ResourceNotFoundException;
import com.example.back.model.Employee;
import com.example.back.repository.Emp_rep;

@RestController
@RequestMapping("/api/cv/")
@CrossOrigin(origins="http://localhost:4200")
public class Ctrl {
	@Autowired
	private Emp_rep emp_rep;
	
	
	@GetMapping("/employee")
	
	public List<Employee> getAll(){
		return emp_rep.findAll();
		
	}
	@PostMapping("/employee")
	
	public Employee createEmp(@RequestBody Employee employee) {
		return emp_rep.save(employee);
		
		
	}
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getById(@PathVariable Long id) {
		Employee employee=emp_rep.findById(id).orElseThrow(()->new ResourceNotFoundException("employee not found"));
		return ResponseEntity.ok(employee);
		
	}
	@PutMapping("/employee/{id}")
	
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,@RequestBody Employee employeeDet){
		Employee employee=emp_rep.findById(id).orElseThrow(()->new ResourceNotFoundException("employee not found"));
		employee.setName(employeeDet.getName());
		employee.setLastname(employeeDet.getLastname());
		employee.setEmailid(employeeDet.getEmailid());
		return ResponseEntity.ok( emp_rep.save(employee));
		
		
		
	}
	@DeleteMapping("/employee/{id}")
	public ResponseEntity <Map<String,Boolean>> deleteEmployee(@PathVariable Long id){
		Employee employee=emp_rep.findById(id).orElseThrow(()->new ResourceNotFoundException("not found"));
		
		emp_rep.delete(employee);
		Map<String,Boolean> response=new HashMap<>();
		response.put("delete", Boolean.TRUE);
		
		return ResponseEntity.ok(response);
		
	}
	}
	


