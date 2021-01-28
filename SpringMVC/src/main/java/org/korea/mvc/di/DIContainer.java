package org.korea.mvc.di;

import org.korea.mvc.dao.MemberDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DIContainer {
	
	
	@Bean
	public MemberDAO employee() {
		return new MemberDAO();
	}
	
}













