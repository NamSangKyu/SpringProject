package org.korea.mvc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.korea.mvc.dto.StudentDTO;
import org.korea.mvc.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {
	private StudentService service;

	public StudentController(StudentService service) {
		this.service = service;
	}
	
	@RequestMapping("/student.do")
	public String stduentMain(HttpServletRequest request) {
		ArrayList<StudentDTO> list = service.selectAllStudent();
		request.setAttribute("list", list);
		return "student_manager";
	}
	
	
}







