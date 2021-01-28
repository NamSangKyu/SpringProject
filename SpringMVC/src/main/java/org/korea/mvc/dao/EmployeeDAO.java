package org.korea.mvc.dao;

import config.DBManager;

public class EmployeeDAO {
	private DBManager manager;

	public EmployeeDAO(DBManager manager) {
		super();
		this.manager = manager;
		System.out.println("EmployeeDAO 생성");
	}
	
	
	
}
