package com.testpackage.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

import com.testpackage.dto.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	JdbcTemplate jdbcTemplate;
	DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void addEmployees(List<Employee> elist) {
		// TODO Auto-generated method stub
		String INSERT_EMPLOYEE_SQL = "INSERT INTO EMPLOYEE(EID,ENAME,EADDRESS) VALUES (?,?,?)";
		jdbcTemplate.batchUpdate(INSERT_EMPLOYEE_SQL, new BatchPreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement preparedStatement, int index) throws SQLException {
				// TODO Auto-generated method stub
				preparedStatement.setInt(1, elist.get(index).getEid());
				preparedStatement.setString(2, elist.get(index).getEname());
				preparedStatement.setString(3, elist.get(index).getEaddress());
			}

			@Override
			public int getBatchSize() {
				// TODO Auto-generated method stub
				return elist.size();
			}
		});

	}

	@Override
	public boolean addEmployee(Employee e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateEmployee(Employee e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteEmployee(Employee e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean seacrhEmployee(Employee e) {
		// TODO Auto-generated method stub
		return false;
	}

}
