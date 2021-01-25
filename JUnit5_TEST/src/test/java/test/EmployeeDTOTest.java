package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmployeeDTOTest {

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("테스트 작업전 수행");
	}

	@Test
	void testSelectEmployeeList() {
		System.out.println("testSelectEmployeeList");
//		fail("Not yet implemented");//작업 실패시 나타낼 행동
	}

	@Test
	void testSelectBottom5Salary() {
		System.out.println("testSelectBottom5Salary");
//		fail("Not yet implemented");
	}
	@AfterEach
	void end() {
		System.out.println("테스트 작업 후 실행");
	}

}






