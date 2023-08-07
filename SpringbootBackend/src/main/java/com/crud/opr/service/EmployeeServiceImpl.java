package com.crud.opr.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.opr.entity.Employee;
import com.crud.opr.exception.ResourceNotFoundException;
import com.crud.opr.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	//@Autowired - it has one constructor so dependencies are automatically get download
	private EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee saveEmployee(Employee employee) {

		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(long id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		if(employee.isPresent()) {
			return employee.get();
		}
		else {
			throw new ResourceNotFoundException("employee", "Id", id);
		}
		//return null;
	}

	@Override
	public Employee updateEmployee(Employee employee, long id) {
		//first we need to check whether employee with given id is exist in DB or not
		Employee existingEmployee =employeeRepository.findById(id).orElseThrow( ()->new ResourceNotFoundException("Employee", "Id", id));
		
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		//save existing employee to DB
		employeeRepository.save(existingEmployee);
		return existingEmployee;
	}

	@Override
	public void deleteEmployee(long id) {
		//check whether employee is exist or not
		employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee", "Id", id));
		employeeRepository.deleteById(id);
	}

}
