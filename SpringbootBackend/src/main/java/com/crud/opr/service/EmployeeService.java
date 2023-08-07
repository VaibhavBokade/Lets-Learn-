package com.crud.opr.service;

import java.util.List;

import com.crud.opr.entity.Employee;


public interface EmployeeService {
	Employee saveEmployee(Employee employee);
	List<Employee> getAllEmployees();
	Employee getEmployeeById(long id); 
	Employee updateEmployee(Employee employee, long id);
	void deleteEmployee(long id);	
	
}
