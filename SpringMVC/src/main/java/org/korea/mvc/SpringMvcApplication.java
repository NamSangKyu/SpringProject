package org.korea.mvc;

import java.util.Calendar;
import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringMvcApplication {
	
	@PostConstruct
	void changeTimeZone() {
		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"));
		System.out.println(Calendar.getInstance().getTime().toLocaleString());
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringMvcApplication.class, args);
		System.out.println("서버 구동 완료");
	}

}
