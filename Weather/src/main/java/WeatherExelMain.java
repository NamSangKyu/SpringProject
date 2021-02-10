import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.openxml4j.util.ZipSecureFile;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WeatherExelMain {

	public static void main(String[] args) {
		FileInputStream fis;
		try {
			ZipSecureFile.setMinInflateRatio(0);
			fis = new FileInputStream("excel.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);
			Scanner sc = new Scanner(System.in);
			System.out.println("조회할 주소를 정확하게 서울특별시 강서구  <--- 형식으로 입력하세요");
			String address = sc.nextLine();
			String addr[] = address.split(" ");
			String nx = null, ny=null;
			for(int i=0;i<sheet.getPhysicalNumberOfRows();i++) {
				if(sheet.getRow(i).getCell(2).getStringCellValue().equals(addr[0])) {
					if(sheet.getRow(i).getCell(3).getStringCellValue().equals(addr[1])) {
						nx = sheet.getRow(i).getCell(5).getStringCellValue();
						ny = sheet.getRow(i).getCell(6).getStringCellValue();
					}
				}
			}
			System.out.println(nx + " "+ ny);
			
			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}











