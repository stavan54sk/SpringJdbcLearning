package com.testpackage.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.AbstractLobCreatingPreparedStatementCallback;
import org.springframework.jdbc.core.support.AbstractLobStreamingResultSetExtractor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.support.lob.LobCreator;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.util.FileCopyUtils;

import com.testpackage.dto.Student;

public class StudentDaoImpl implements StudentDao {

	JdbcTemplate jdbcTemplate;
	DriverManagerDataSource dataSource;
	LobHandler lobHandler;

	public void setDataSource(DriverManagerDataSource dataSource) {
		this.dataSource = dataSource;
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public LobHandler getLobHandler() {
		return lobHandler;
	}

	public void setLobHandler(LobHandler lobHandler) {
		this.lobHandler = lobHandler;
	}

	@Override
	public void addStudentDetails(Student student) {

		String INSERT_STUDENT_SQL = "INSERT INTO STUDENT (S_ID, S_NAME,S_IMAGE) VALUES (?,?,?)";

		jdbcTemplate.execute(INSERT_STUDENT_SQL, new AbstractLobCreatingPreparedStatementCallback(lobHandler) {

			@Override
			protected void setValues(PreparedStatement preparedStatement, LobCreator lobCreator)
					throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				preparedStatement.setInt(1, student.getId());
				preparedStatement.setString(2, student.getName());
				try {
					lobCreator.setBlobAsBinaryStream(preparedStatement, 3, new FileInputStream(student.getImage()),
							(int) student.getImage().length());
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

	}

	@Override
	public Student getStudentDetails(int id) {
		
		Student student=new Student();

		String SELECT_STUDENT_SQL = "SELECT * FROM STUDENT WHERE S_ID="+id;

		jdbcTemplate.query(SELECT_STUDENT_SQL, new AbstractLobStreamingResultSetExtractor<Object>() {

			@Override
			protected void streamData(ResultSet resultSet) throws SQLException, IOException, DataAccessException {
				// TODO Auto-generated method stubstuden
				student.setId(resultSet.getInt(1));
				student.setName(resultSet.getString(2));
				FileCopyUtils.copy(lobHandler.getBlobAsBinaryStream(resultSet, 3), new FileOutputStream(new File("C:\\Users\\Admin\\Desktop\\MyPhoto.jpeg")));
				student.setImage(new File("C:\\Users\\Admin\\Desktop\\MyPhoto.jpeg"));
			}
		});
		return student;

			
	}

}
