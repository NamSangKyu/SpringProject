package com.db;

import java.util.List;

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
	
}







