package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.json.JSONArray;

import config.DBManager;
import dto.EmployeeDTO;

public class EmployeeDAO {
	private static EmployeeDAO instance = new EmployeeDAO();
	private Connection conn;
	
	private EmployeeDAO() {
		conn = DBManager.getInstance().getConnection();
	}

	public static EmployeeDAO getInstance() {
		if(instance == null)
			instance = new EmployeeDAO();
		return instance;
	}

	public String selectEmployeeList(int position) {
		String result = null;
		String sql = "select * from employee where position >= ?";
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, position);
			rs = pstmt.executeQuery();
			ArrayList<EmployeeDTO> list = new ArrayList<EmployeeDTO>();
			while(rs.next()) {
				list.add(new EmployeeDTO(rs.getString(1), rs.getString(2), 
						rs.getString(3), rs.getInt(4)));
			}
			JSONArray array = new JSONArray(list);
			result = array.toString();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return result;
	}
	public ArrayList<EmployeeDTO> selectEmployeeAllList() {
		String sql = "select * from employee";
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		ArrayList<EmployeeDTO> list = new ArrayList<EmployeeDTO>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new EmployeeDTO(rs.getString(1), rs.getString(2), 
						rs.getString(3), rs.getInt(4)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public String selectBottom5Salary() {
		String result = null;
		String sql = "select rownum, eno,name, department, position_name, salary, position "
				+ "from(select e.eno, e.name, e.department, p.position_name, s.salary, e.position "
				+ "from employee e, position_list p , employee_salary s "
				+ "where e.eno = s.eno and e.position = p.position_no order by s.salary)"
				+ " where rownum <= 5";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		System.out.println(sql);
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			ArrayList<EmployeeDTO> list = new ArrayList<EmployeeDTO>();
			while(rs.next()) {
				list.add(new EmployeeDTO(rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7)));
			}
			JSONArray array = new JSONArray(list);
			result = array.toString();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	//사원번호로 사원정보 정확하게 1건 검색하는 기능을 작업 - return EmployeeDTO
	public EmployeeDTO selectEmployee(String eno) {
		String sql = "select e.eno, e.name, e.department, e.position, "
				+ "s.salary, p.position_name from EMPLOYEE e, EMPLOYEE_SALARY s ,"
				+ " position_list p where e.eno = s.eno and e.position = p.position_no and e.eno = ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		EmployeeDTO dto = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, eno);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				   dto = new EmployeeDTO(rs.getString(1), rs.getString(2), rs.getString(3),
						   rs.getString(6), rs.getInt(5), rs.getInt(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}
	
}
























