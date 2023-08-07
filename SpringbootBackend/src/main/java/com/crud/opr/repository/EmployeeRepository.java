package com.crud.opr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.opr.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
