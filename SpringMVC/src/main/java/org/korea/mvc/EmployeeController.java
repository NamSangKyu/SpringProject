package org.korea.mvc;

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
	public String employeeMain() {
		return "employee_manager";
	}
	
}
