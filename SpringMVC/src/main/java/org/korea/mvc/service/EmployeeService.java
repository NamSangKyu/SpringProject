package org.korea.mvc.service;

import org.korea.mvc.dao.EmployeeDAO;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	private EmployeeDAO dao;

	public EmployeeService(EmployeeDAO dao) {
		super();
		this.dao = dao;
	}
	
}
