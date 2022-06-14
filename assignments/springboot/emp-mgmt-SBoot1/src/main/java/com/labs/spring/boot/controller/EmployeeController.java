package com.labs.spring.boot.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.labs.spring.boot.Entity.Employee;
import com.labs.spring.boot.exception.EmployeeException;
import com.labs.spring.boot.service.EmployeeService;
import com.labs.spring.boot.service.EmployeeServiceImpl;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	@Autowired
	EmployeeServiceImpl empService;
	ResponseMessage response;

	// Create employee POST Method to create employee
	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<ResponseMessage> create(@RequestBody Employee employee)
			throws URISyntaxException, EmployeeException {

		Employee employeeCreated = empService.create(employee);		

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(employeeCreated.getId()).toUri();
		response = new ResponseMessage("Success", "Employee created successfully");
		return ResponseEntity.created(location).body(response);
	}

	// update Employee
	@PutMapping(path = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })

	public ResponseEntity<ResponseMessage> update(@PathVariable int id, @RequestBody Employee employee)
			throws EmployeeException {		
		employee.setId(id);
		Employee updatedEmployee = empService.update(employee.getId(), employee);
		response = new ResponseMessage("Success", "Employee updated successfully");
		return ResponseEntity.ok().body(response);
	}

	// Delete Employee
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<ResponseMessage> delete(@PathVariable int id) {
		empService.delete(id);
		response = new ResponseMessage("Success", "Employee deleted successfully");
		return ResponseEntity.ok().body(response);

	}

	// To get all the employee
	@GetMapping
	public List<Employee> getAll() throws EmployeeException {
		return empService.list();
	}

	// Get employee for particular employee
	@GetMapping("/{id}")
	public Employee get(@PathVariable int id) throws EmployeeException {
		return empService.get(id);
	}


}
