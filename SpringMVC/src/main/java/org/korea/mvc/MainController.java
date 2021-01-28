package org.korea.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("/") //url만 입력했을때 www.google.com
	public String main() {
		System.out.println("main()");
		return "main";
	}
	
}
