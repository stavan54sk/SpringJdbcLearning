package com.testpackage.test;

import java.io.File;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.testpackage.configuration.ConfigurationClass;
import com.testpackage.dao.StudentDao;
import com.testpackage.dto.Student;

public class TestClass {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConfigurationClass.class);
		StudentDao studentDao = (StudentDao) applicationContext.getBean("studentDao");
		Student student = new Student();
		student.setId(111);
		student.setName("Stavan Kodolikar");
		student.setImage(new File("F:\\STAVAN_PHONE.png"));
//		studentDao.addStudentDetails(student);
		
		studentDao.getStudentDetails(111);
	}

}
