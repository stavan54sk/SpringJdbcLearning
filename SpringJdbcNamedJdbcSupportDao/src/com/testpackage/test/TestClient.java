package com.testpackage.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.testpackage.dao.EmployeeDao;
import com.testpackage.dto.Employee;


public class TestClient {

	public static void main(String[] args) {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("\\com\\testpackage\\configuration\\applicationContext.xml");
		
		EmployeeDao employeeDao=(EmployeeDao) applicationContext.getBean("employeeDao");
		
		Employee employee=new Employee();
		employee.setId("117");
		employee.setName("Satish");
		employee.setAddress("Kodoli");
		
//		employeeDao.craeteEmployee(employee);
		System.out.println(employeeDao.searchEmployee(115));
		
		
//		
//		try{  
//		Class.forName("com.mysql.cj.jdbc.Driver");  
//		Connection con=DriverManager.getConnection("jdbc:mysql://database-1.caqh9f9qhset.ap-south-1.rds.amazonaws.com:3306/classicmodels","root","root1234");  
//		//here sonoo is database name, root is username and password  
//		Statement stmt=con.createStatement();  
//		ResultSet rs=stmt.executeQuery("Select *from Employee");  
//		while(rs.next())  
//		System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
//		con.close();  
//		}catch(Exception e){ System.out.println(e);}  
//	 
	}
}
