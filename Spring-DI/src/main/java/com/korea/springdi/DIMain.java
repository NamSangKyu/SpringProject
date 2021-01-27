package com.korea.springdi;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DIMain {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppContext.class);
		Greeting g1 = context.getBean("greeter",Greeting.class);
		Greeting g2 = context.getBean("greeter",Greeting.class);
		g1.printInfo();
		g2.printInfo();
		Person p = context.getBean(Person.class);
		System.out.println(p.toString());
		Person e = context.getBean("person",Person.class);
		System.out.println(e.toString());
	}

}
