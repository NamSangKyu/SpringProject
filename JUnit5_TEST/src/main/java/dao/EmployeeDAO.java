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
	
	
}












