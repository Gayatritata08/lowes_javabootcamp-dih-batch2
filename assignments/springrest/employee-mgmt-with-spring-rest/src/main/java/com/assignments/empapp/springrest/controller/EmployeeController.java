package com.assignments.empapp.springrest.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.assignments.empapp.springrest.exception.EmployeeException;
import com.assignments.empapp.springrest.model.Employee;
import com.assignments.empapp.springrest.model.ResponseMessage;
import com.assignments.empapp.springrest.service.EmployeeServiceImpl;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

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
				.buildAndExpand(employeeCreated.getEmpId()).toUri();
		response = new ResponseMessage("Success", "Employee created successfully");
		return ResponseEntity.created(location).body(response);
	}

	// update Employee
	@PutMapping(path = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })

	public ResponseEntity<ResponseMessage> update(@PathVariable int id, @RequestBody Employee employee)
			throws EmployeeException {		
		employee.setEmpId(id);
		Employee updatedEmployee = empService.update(employee.getEmpId(), employee);
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
		return empService.getAll();
	}

	// Get employee for particular employee
	@GetMapping("/{id}")
	public Employee get(@PathVariable int id) throws EmployeeException {
		return empService.get(id);
	}

}
