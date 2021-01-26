package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import config.DBManager;
import dao.EmployeeDAO;
import dto.EmployeeDTO;

class EmployeeTest {
	private static Connection conn = null;
	@BeforeAll
	static void setup() throws Exception {
		//json 파일 읽기
		File file = new File("employee.json");
		//System.out.println(file.exists());
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String result = "";
		while(true) {
			String str = br.readLine();
			if(str == null) break;
			result += str; 
		}
		System.out.println(result);
		//json 처리
		JSONArray array = new JSONArray(result);
		//DB연결
		conn =  DBManager.getInstance().getConnection();
		conn.setAutoCommit(false);
		String sql = "insert into employee values(?,?,?,?)";
		PreparedStatement pstmt = null;
		for(int i=0;i<array.length();i++) {
			pstmt = conn.prepareStatement(sql);
			JSONObject object = new JSONObject(array.get(i).toString());
			pstmt.setString(1, object.getString("eno"));
			pstmt.setString(2, object.getString("name"));
			pstmt.setString(3, object.getString("department"));
			pstmt.setInt(4, object.getInt("position"));
			pstmt.executeUpdate();
			pstmt.close();
		}
	}

	@DisplayName("전체 사원 정보 조회")
	@Test
	void testSelectAllEmployee() {
		ArrayList<EmployeeDTO> list = EmployeeDAO.getInstance().selectEmployeeAllList();
		if(list.size() == 0)
			fail("조회할 데이터가 없습니다.");
		else {
			for(int i=0;i<list.size();i++) {
				System.out.println(list.get(i));
			}
		}
	}
	
	@DisplayName("해당 사원 정보 삭제")
	@Test
	public void testDeleteEmployee() {
		String eno = "MR62";
		String sql = "delete from employee where eno = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, eno);
			int count = pstmt.executeUpdate();
			
			assertEquals(count, 1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	@AfterAll
	public static void end() {
		try {
			conn.rollback();
			conn.close();
			System.out.println("롤백 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}







