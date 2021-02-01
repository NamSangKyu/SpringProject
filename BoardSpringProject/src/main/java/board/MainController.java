package board;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;
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

	@RequestMapping("logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return main();
	}

	@RequestMapping("login.do")
	public String login(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		MemberDTO dto = memberService.login(id, pass);
		// HttpSession session = request.getSession();
		if (dto != null) {
			session.setAttribute("login", true);
			session.setAttribute("id", dto.getId());
			session.setAttribute("name", dto.getName());
			session.setAttribute("grade", dto.getGrade());
			session.setMaxInactiveInterval(10 * 60);

			return "main";
		} else {
			try {
				response.setContentType("text/html;charset=utf-8");
				response.getWriter().write("<script>alert('아이디 비번을 확인하세요');history.back();</script>");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return null;
	}

	@RequestMapping("/updateMemberView.do")
	public String updateMemberView(HttpServletRequest request, HttpSession session) {

		String id = (String) session.getAttribute("id");

		// 세션 정보가 유효한지 체크
		if (id == null)
			return "login";

		// 회원정보 조회
		MemberDTO dto = memberService.selectMember(id);
		request.setAttribute("dto", dto);

		return "member_update_view";
	}

	@RequestMapping("/updateMemberAction.do")
	public String updateMemberAction(HttpServletRequest request, HttpServletResponse response) {
		String id = (String) request.getSession().getAttribute("id");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));

		if (id == null) {
			// 세션이 만료된 경우
			try {
				response.setContentType("text/html; charset=utf-8");
				response.getWriter().write(
						"<script>alert('세션이 만료되었습니다." + " 다시 로그인해 주세요');" + "location.href='login.do';</script>");
				return null;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		memberService.updateMember(new MemberDTO(id, pass, name, age));

		return "main";

	}

	@RequestMapping("/memberAdminMain.do")
	public String memberAdminMain(HttpServletRequest request) {
		List<MemberDTO> list = memberService.selectAllMember();
		request.setAttribute("list", list);
		return "member_manage_main";
	}

	@RequestMapping("/memberSerach.do")
	public String memberAdminSearch(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String kind = request.getParameter("kind");
		String search = request.getParameter("search");
		List<MemberDTO> list = memberService.selectSearchMember(kind, search);
		response.setContentType("text/html;charset=utf-8");
		JSONArray array = new JSONArray(list);
		JSONObject obj = new JSONObject();
		obj.put("result", array);
		try {
			response.getWriter().write(obj.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping("/memberAjaxUpdate.do")
	public String memberAjaxUpdate(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String grade = request.getParameter("grade");

		MemberDTO dto = new MemberDTO(id, null, name, age, grade);
		int count = memberService.updateMemberAdmin(dto);
		try {
			if (count == 1)
				response.getWriter().write("true");
			else
				response.getWriter().write("false");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping("/memberAjaxDelete.do")
	public String memberAjaxDelete(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		int count = memberService.deleteMemberAdmin(id);
		try {
			response.getWriter().write(count + "");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
}













