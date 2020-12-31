package com.testpackage.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.testpackage.dao.EmployeeDao;
import com.testpackage.dao.EmployeeDaoImpl;
import com.testpackage.dto.Employee;

public class TestClient {

	public static void main(String[] args) {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("\\com\\testpackage\\configuration\\applicationContext.xml");
		EmployeeDao employeeDao=(EmployeeDaoImpl)applicationContext.getBean("employeedaoimpl");
		List<Employee> employeeList =new ArrayList<>();
		Employee employee1=new Employee();
		employee1.setEid(111);
		employee1.setEname("STAVAN");
		employee1.setEaddress("PUNE");
		Employee employee2=new Employee();
		employee2.setEid(222);
		employee2.setEname("STUVI");
		employee2.setEaddress("LONDON");
		Employee employee3=new Employee();
		employeeList.add(employee1);
		employeeList.add(employee2);
		employeeDao.addEmployees(employeeList);
		
	}
}

