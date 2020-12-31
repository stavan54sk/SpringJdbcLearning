package com.testpackage.dao;

import com.testpackage.dto.Student;

public interface StudentDao {
	void addStudentDetails(Student student);
	Student getStudentDetails(int id);
}
