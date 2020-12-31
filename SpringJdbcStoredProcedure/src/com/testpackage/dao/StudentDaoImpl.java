package com.testpackage.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import com.testpackage.dto.Student;

public class StudentDaoImpl implements StudentDao {

	JdbcTemplate jdbcTemplate;
	DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		 this.dataSource=dataSource;
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void addStudent(Student s) {
		// TODO Auto-generated method stub
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(dataSource);
		simpleJdbcCall.withProcedureName("addstudent");
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource().addValue("sid", s.getId())
				.addValue("sname", s.getName()).addValue("saddress", s.getAddress());
		simpleJdbcCall.execute(sqlParameterSource);

	}

	@Override
	public void updateStudent(Student s) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteStudent(Student s) {
		// TODO Auto-generated method stub

	}

	@Override
	public void getStudent(Student s) {
		// TODO Auto-generated method stub

	}

}
