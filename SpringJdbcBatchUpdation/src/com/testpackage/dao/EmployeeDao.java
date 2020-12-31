package com.testpackage.dao;

import java.util.List;

import com.testpackage.dto.Employee;

public interface EmployeeDao {
	
	void addEmployees(List<Employee> elist);
	
	boolean addEmployee(Employee e);

	boolean updateEmployee(Employee e);

	boolean deleteEmployee(Employee e);

	boolean seacrhEmployee(Employee e);

}
