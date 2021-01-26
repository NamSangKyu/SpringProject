package employee;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import dao.EmployeeDAO;
import dto.EmployeeDTO;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/register.do")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		String eno = request.getParameter("eno");
		String name = request.getParameter("name");
		String department = request.getParameter("department");
		int position = Integer.parseInt(request.getParameter("position"));
		//데이터 검증 DAO로 보내기 전에 수행
	
		if(eno.length()>4) 
			throw new ServletException("100");
		EmployeeDAO.getInstance().insertEmployee(new EmployeeDTO(eno, name, department, position));
		ArrayList<EmployeeDTO> list = EmployeeDAO.getInstance().selectEmployeeAllList();
		JSONArray arr = new JSONArray(list);//json으로 변형
		JSONObject obj = new JSONObject();
		obj.put("result", arr);
		response.getWriter().write(obj.toString());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
