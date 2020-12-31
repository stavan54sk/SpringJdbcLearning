package com.testpackage.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.testpackage.dto.Employee;
import com.testpackage.rowmapper.EmployeeRowMapper;

public class EmployeeDaoImpl extends NamedParameterJdbcDaoSupport implements EmployeeDao {

	@Override
	public void craeteEmployee(Employee employee) {
		String sql = "INSERT INTO employee (eid, ename, eaddress) VALUES (:eid,:ename,:eaddress)";
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>();
		map.put("eid", employee.getId());
		map.put("ename", employee.getName());
		map.put("eaddress", employee.getAddress());
		getNamedParameterJdbcTemplate().update(sql, map);

	}

	@Override
	public List<Employee> searchEmployee(int eid) {
		
		MapSqlParameterSource mapSqlParameterSource =new MapSqlParameterSource();
		mapSqlParameterSource.addValue("eid", 117);
				
		
		List<Employee> employees = getNamedParameterJdbcTemplate().query("Select * from Employee where eid = :eid", mapSqlParameterSource,
				new EmployeeRowMapper());
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
