package org.korea.mvc.di;

import org.korea.mvc.dao.MemberDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DIContainer {
	private static AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
			DIContainer.class);

	public static AnnotationConfigApplicationContext getContext() {
		return context;
	}
	@Bean
	public MemberDAO memberdao() { 
		return new MemberDAO();
	}
}
