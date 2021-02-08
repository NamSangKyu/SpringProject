package papago;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	AnnotationConfigApplicationContext appContext;
	
	public MainController() {
		appContext = new AnnotationConfigApplicationContext(DIContainer.class);
	}
	@RequestMapping("/")
	public String main() {
		return "papago_main";
	}
	@RequestMapping("/translate.do")
	public String translate(HttpServletRequest request, HttpServletResponse response) {
		//번역할 내용 및 언어 코드를 받아서, 뷰로 전송
		//번역 처리할 부분은 따로 별로의 클래스를 만들어서 작업 - DI 작업
		String target = request.getParameter("target");
		String text = request.getParameter("text");
		String source = request.getParameter("source");
		System.out.println(target + " " + text + " " + source);
		String result = appContext.getBean("papago",PaPaGo.class).translatePaPaGo(target, source, text);
		
		try {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}







