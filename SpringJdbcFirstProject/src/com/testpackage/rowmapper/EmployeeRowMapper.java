package com.testpackage.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import com.testpackage.dto.Employee;

public class EmployeeRowMapper implements RowMapper<Employee> {
	
	

	@Override
	public Employee mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		Employee employee=new Employee();
		employee.setId(resultSet.getString("eid"));
		employee.setName(resultSet.getString("ename"));
		employee.setAddress(resultSet.getString("eaddress"));
		return employee;
	}

}
