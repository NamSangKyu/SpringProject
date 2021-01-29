package board;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import board.dto.MemberDTO;
import board.service.MemberService;
@Controller
public class MainController {
	private MemberService memberService;
	
	public MainController(MemberService memberService) {
		super();
		this.memberService = memberService;
	}

	@RequestMapping("/")
	public String main() {
		return "main";
	}
	
	@RequestMapping("loginView.do")
	public String loginView() {
		return "login";
	}
	@RequestMapping("login.do")
	public String login(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		String id = request.getParameter("id");
		String pass =request.getParameter("pass");
		MemberDTO dto = memberService.login(id,pass);
		//HttpSession session = request.getSession();
		if(dto != null) {
			session.setAttribute("login", true);
			session.setAttribute("id", dto.getId());
			session.setAttribute("name", dto.getName());
			String grade = null;
			switch(dto.getGrade()) {
			case 0:
				grade = "master";
				break;
			case 1:
				grade = "bronze";
				break;
			case 2:
				grade = "gold";
				break;
			case 3:
				grade = "vip";
				break;
			case 4:
				grade = "vvip";
				break;
			}
			session.setAttribute("grade", grade);
			
			return "main";
		}else {
			try {
				response.setContentType("text/html;charset=utf-8");
				response.getWriter().write("<script>alert('아이디 비번을 확인하세요');history.back();</script>");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}
}












