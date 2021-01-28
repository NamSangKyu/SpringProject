package org.korea.mvc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.korea.mvc.dto.EmployeeDTO;
import org.korea.mvc.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmployeeController {
	private EmployeeService service;

	public EmployeeController(EmployeeService service) {
		super();
		this.service = service;
	}
	
	@RequestMapping("/employee.do")
	public String employeeMain(HttpServletRequest request) {
		ArrayList<EmployeeDTO> list = service.selectAllEmployee();
		request.setAttribute("list", list);
		return "employee_manager";
	}
	
}










