package org.korea.mvc.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.korea.mvc.dto.EmployeeDTO;

import config.DBManager;

public class EmployeeDAO {
	private DBManager manager;

	public EmployeeDAO(DBManager manager) {
		super();
		this.manager = manager;
		System.out.println("EmployeeDAO 생성");
	}

	public ArrayList<EmployeeDTO> selectAllEmployee() {
		ArrayList<EmployeeDTO> list = new ArrayList<EmployeeDTO>();
		String sql = "select * from employee";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = manager.getConnection().prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new EmployeeDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			manager.close(pstmt, rs);
		}
		
		return list;
	}
	
	
	
}





