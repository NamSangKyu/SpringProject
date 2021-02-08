package papago;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DIContainer {
	@Bean
	public PaPaGo papago() {
		return new PaPaGo();
	} 
}
