package org.korea.mvc;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	
	@RequestMapping("/") //url만 입력했을때 www.google.com
	public String main() {
		System.out.println("main()");
		return "main";
	}
	
	@RequestMapping("/loginAction.do")
	public String loginAction(@RequestParam("id") String id, @RequestParam("pass")String pass, HttpSession session) {
		System.out.println("loginAction()");
		System.out.println(id +","+pass);
		System.out.println(session.getId());
		return "main";
		
	}
	
	
}





