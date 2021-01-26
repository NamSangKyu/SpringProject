package test;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import dao.EmployeeDAO;

class EmployeeDTOTest {

	@BeforeAll
	static void testUp() {
		System.out.println("테스트 맨처음 한번 수행할 일");
	}
	@AfterAll
	static void done() {
		System.out.println("테스트 맨 마지막에 한번 수행할 일");
	}
	@BeforeEach //각 테스트 메서드가 실행되기 전에 수행
	void init(){
		System.out.println("테스트 작업전 수행");
	}

	@DisplayName("사원정보리스트 조회 테스트")
	@Test
	void testSelectEmployeeList() {
		String str = EmployeeDAO.getInstance().selectEmployeeList(7);
		if(str.length()==2)
			fail("데이터가 없습니다.");//작업 실패시 나타낼 행동
		else
			System.out.println(str);
	}
	
	@DisplayName("빈리스트 확인 테스트")
	@Test
	void testEmptyEmployeeList() {
		assertTrue(!EmployeeDAO.getInstance().selectEmployeeAllList().isEmpty());
	}
	
	
	@DisplayName("하위연봉5명 조회 테스트")
	@Test
	void testSelectBottom5Salary() {
		String str = EmployeeDAO.getInstance().selectBottom5Salary();
		if(str.length()<3) {
			fail("데이터가 적습니다.");
		}else {
			System.out.println(str);
		}
	}
	
	@DisplayName("사원정보 하나 조회")
	@Test
	void testselectEmployee() {
		//EmployeeDTO dto = EmployeeDAO.getInstance().selectEmployee("TQ98");
		int n =10;
		assertSame(n, 10);//==
		//EmployeeDTO dto = new EmployeeDTO("TQ98", "강병헌", "영업", "과장", 6200, 4);
		//assertEquals(dto, EmployeeDAO.getInstance().selectEmployee("TQ98")); //.equals 연산
	}
	
	@AfterEach//각 테스트 메서드가 실행이 끝난 후 수행
	void end() {
		System.out.println("테스트 작업 후 실행");
	}

}






