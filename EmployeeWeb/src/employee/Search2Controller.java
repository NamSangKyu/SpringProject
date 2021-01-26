package employee;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import dao.EmployeeDAO;
import dao.EmployeeDAO2;
import dto.EmployeeDTO;

/**
 * Servlet implementation class Search2Controller
 */
@WebServlet("/search2.do")
public class Search2Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search2Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		//검색어를 받은 후 - DAO로 가서 해당 회원 목록(입력한 이름으로 부분 검색)을 읽어옴
		System.out.println("Search2Controller");
		String name = request.getParameter("name");
		System.err.println(name);
		ArrayList<EmployeeDTO> list = null;
		try {
			EmployeeDAO2 dao = new EmployeeDAO2();
			list = dao.selectEmployeeName(name);
			JSONArray array = new JSONArray(list);
			response.getWriter().write(array.toString());
			System.out.println(array.toString());
		} catch (Exception e) {
			e.printStackTrace();
			response.sendError(444,"에러 메세지");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
