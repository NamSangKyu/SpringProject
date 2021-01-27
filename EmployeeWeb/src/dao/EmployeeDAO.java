package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;

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
		if (instance == null)
			instance = new EmployeeDAO();
		return instance;
	}

	public ArrayList<EmployeeDTO> selectEmployeeAllList() {
		String sql = "select * from employee";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<EmployeeDTO> list = new ArrayList<EmployeeDTO>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new EmployeeDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// 사원번호로 사원정보 정확하게 1건 검색하는 기능을 작업 - return EmployeeDTO
	public EmployeeDTO selectEmployee(String eno) {
		String sql = "select * from employee where e.eno = ?";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		EmployeeDTO dto = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, eno);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto = new EmployeeDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}

	public ArrayList<EmployeeDTO> selectEmployeeName(String name) throws Exception {
		String sql = "select * from employee where name like '%'||?||'%'";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<EmployeeDTO> list = new ArrayList<EmployeeDTO>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new EmployeeDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (list.size() == 0)
			throw new Exception("데이터가 없습니다.");

		return list;
	}

	public void insertEmployee(EmployeeDTO employeeDTO) throws SQLException {
		String sql = "insert into employee values(?,?,?,?)";
		PreparedStatement pstmt = null;
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, employeeDTO.getEno());
		pstmt.setString(2, employeeDTO.getName());
		pstmt.setString(3, employeeDTO.getDepartment());
		pstmt.setInt(4, employeeDTO.getPosition());
		pstmt.executeUpdate();
		pstmt.close();
	}

}







