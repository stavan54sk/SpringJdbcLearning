package com.testpackage.dao;

import com.testpackage.dto.Student;

public interface StudentDao {
	void addStudent(Student s);

	void updateStudent(Student s);

	void deleteStudent(Student s);

	void getStudent(Student s);

}
