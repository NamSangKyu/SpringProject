package book;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@RequestMapping("/")
	public String main() {
		return "book_search";
	}
	@RequestMapping("/search.do")
	public String search(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.setContentType("text/html;charset=utf-8");
			JSONObject json = new JSONObject();
			json.put("title", request.getParameter("title"));
			json.put("responseCode", "200");
			
			response.getWriter().write(json.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
