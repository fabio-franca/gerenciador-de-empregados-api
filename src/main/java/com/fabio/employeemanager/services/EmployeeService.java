package com.fabio.employeemanager.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabio.employeemanager.exception.UserNotFoundException;
import com.fabio.employeemanager.model.Employee;
import com.fabio.employeemanager.repository.EmployeeRepo;

@Service
public class EmployeeService {

	private final EmployeeRepo employeeRepo;
	
	@Autowired
	public EmployeeService(EmployeeRepo employeeRepo) {
		this.employeeRepo = employeeRepo; 
	}
	
	//Generated code for employees
	public Employee addEmployee(Employee employee) {
		employee.setEmployeeCode(UUID.randomUUID().toString());
		return employeeRepo.save(employee);
	}
	
	//List
	public List<Employee> findAllEmployees() {
		return employeeRepo.findAll();
	}
	
	//Find
	public Employee findEmployeeById(Long id) {
		return employeeRepo.findEmployeeById(id)
				.orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found..."));
	}
	
	//Update
	public Employee updateEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}
	
	//Delete
	public void deleteEmployee(Long id) {
		employeeRepo.deleteEmployeeById(id);
	}
}
