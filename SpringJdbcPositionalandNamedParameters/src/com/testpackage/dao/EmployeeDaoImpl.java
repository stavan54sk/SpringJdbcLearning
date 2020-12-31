package com.testpackage.dao;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.testpackage.dto.Employee;
import com.testpackage.rowmapper.EmployeeRowMapper;

public class EmployeeDaoImpl implements EmployeeDao {

	JdbcTemplate jdbcTemplate;
	NamedParameterJdbcTemplate  namedParameterJdbcTemplate;
	
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	@Override
	public void craeteEmployee(Employee employee) {
		String sql="INSERT INTO employee (eid, ename, eaddress) VALUES (:eid,:ename,:eaddress)";
		// TODO Auto-generated method stub
		Map<String,Object> map=new HashMap<>();	
		map.put("eid", employee.getId());
		map.put("ename", employee.getName());
		map.put("eaddress", employee.getAddress());
		namedParameterJdbcTemplate.update(sql, map);
		
		
	}

	@Override
	public List<Employee> searchEmployee(int eid) {
		List<Employee> employees=jdbcTemplate.query("Select * from Employee where eid = ?",new Object[] {eid},new EmployeeRowMapper());
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
