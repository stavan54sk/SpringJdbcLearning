package com.testpackage.dao;

import java.util.List;

import com.testpackage.dto.Employee;

public interface EmployeeDao {
	
	public void craeteEmployee();
	
	public List<Employee> searchEmployee();
	
	public void updateEmployee();
	
	public void deleteEmployee();

}
