package com.testpackage.dao;

import java.util.List;

import com.testpackage.dto.Employee;

public interface EmployeeDao {
	
	public void craeteEmployee(Employee employee);
	
	public void updateEmployee();
	
	public void deleteEmployee();

	public List<Employee> searchEmployee(int eid);

}
