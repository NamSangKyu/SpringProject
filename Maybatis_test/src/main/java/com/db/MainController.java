package com.db;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	private StudentService service;

	public MainController(StudentService service) {
		this.service = service;
	}
	
	@RequestMapping("/main.do")
	public String main(Model model) {
		List<StudentDTO> list = service.selectAllStudent();
//		for(int i=0;i<list.size();i++){
//			System.out.println(list.get(i).toString());
//		}
		model.addAttribute("list",list);
		return "main";
	}
	
	@RequestMapping("/register.do")
	public String insert(HttpServletRequest request,Model model) {
		String sno = request.getParameter("sno");
		String name = request.getParameter("name");
		int major = Integer.parseInt(request.getParameter("major"));
		double score = Double.parseDouble(request.getParameter("score"));
		
		int count = service.insertStudent(new StudentDTO(sno, name, major, score));
		System.out.println(count + "건 등록완료");
		return main(model);
	}
	
}













