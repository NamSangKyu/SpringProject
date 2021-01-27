package di;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import config.DBManager;
import dao.EmployeeDAO;
import dto.EmployeeDTO;

@Configuration
public class DIContainer {
	private static AnnotationConfigApplicationContext context 
						= new AnnotationConfigApplicationContext(DIContainer.class);

	public static AnnotationConfigApplicationContext getContext() {
		return context;
	}
	
	@Bean
	public DBManager manager() {
		DBManager m = new DBManager();
		return m;
	}
	
	@Bean
	public EmployeeDAO employee() {
		return new EmployeeDAO(manager());
	}
	
	@Bean
	public EmployeeDTO employeeDTO() {
		return new EmployeeDTO("AAAA","홍길동","영업",1);
		
	}
}














