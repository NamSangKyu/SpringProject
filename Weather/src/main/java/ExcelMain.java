import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.util.ZipSecureFile;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelMain {

	public static void main(String[] args) {
		ZipSecureFile.setMinInflateRatio(0);
		try {
			FileInputStream fis = new FileInputStream("excel.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);//엑셀ㅇ트 번호로 읽어옴
			System.out.println("전체 행 개수 : "+sheet.getPhysicalNumberOfRows());
			System.out.println("해당 라인의 컬럼수 : "+sheet.getRow(0).getPhysicalNumberOfCells());
			System.out.println("4행 6열에 있는 셀값 : "+sheet.getRow(3).getCell(5));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
