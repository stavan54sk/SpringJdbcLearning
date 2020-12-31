package com.testpackage.dao;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.testpackage.dto.Employee;
import com.testpackage.rowmapper.EmployeeRowMapper;

public class EmployeeDaoImpl implements EmployeeDao {

	JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	@Override
	public void craeteEmployee() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Employee> searchEmployee() {
		List<Employee> employees=jdbcTemplate.query("Select * from Employee",new EmployeeRowMapper());
		return employees;
	}

	@Override
	public void updateEmployee() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteEmployee() {
		// TODO Auto-generated method stub

	}

}
