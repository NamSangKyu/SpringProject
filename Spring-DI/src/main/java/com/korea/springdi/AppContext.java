package com.korea.springdi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppContext {
	//사용하기 전에 먼저 생성되어있음
	@Bean
	public Greeting greeter() {
		Greeting g = new Greeting(1000, "di-test");
		return g;
	}
	@Bean
	public Person person() {
		return new Person("홍길동",20);
	}
	
}
