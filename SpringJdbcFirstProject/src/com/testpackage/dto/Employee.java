package com.testpackage.dto;

import lombok.Data;

@Data

public class Employee {
	String name;
	
	String id;

	String address;
	
	@Override
	public String toString() {
		return id+name+address;		
	}
}

