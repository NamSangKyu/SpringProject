package org.korea.mvc.di;

import org.korea.mvc.dao.EmployeeDAO;
import org.korea.mvc.dao.MemberDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import config.DBManager;

@Configuration
public class DIContainer {
		
	@Bean
	public MemberDAO member() {
		return new MemberDAO(manager());
	}
	@Bean
	public DBManager manager() {
		return new DBManager();
	}
	@Bean
	public EmployeeDAO employee() {
		return new EmployeeDAO(manager());
	}
}













