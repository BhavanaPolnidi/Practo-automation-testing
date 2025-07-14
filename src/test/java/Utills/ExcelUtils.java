package Utills;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	private static String path;
	public static FileInputStream fi;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public XSSFRow row;

	public int getRowCount(String sheetName) throws IOException {
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);
		int rowcount = sheet.getLastRowNum();
		workbook.close();
		fi.close();
		return rowcount;
	}

//To get total column no.
	public int getCellCount(String sheetName, int rownum) throws IOException {
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rownum);
		int cellcount = row.getLastCellNum();
		workbook.close();
		fi.close();
		return cellcount;
	}

	public static List<String> InvalidData() throws IOException {
		List<String> Mydata = new ArrayList<String>();
		FileInputStream filepath = new FileInputStream("C:\\Users\\2389291\\OneDrive - Cognizant\\Desktop\\hackathonProject\\src\\test\\resources\\HackathonExcelInput1.xlsx");
		// fi =new FileInputStream(path);
		workbook = new XSSFWorkbook(filepath);
		sheet = workbook.getSheet("Sheet2");
		for (int i = 1; i <= 4; i++) {
			String cellData = sheet.getRow(i).getCell(0).toString();
			Mydata.add(cellData);
		}
		filepath.close();
		workbook.close();
		return Mydata;
	}

	public static List<String> ValidData() throws IOException {
		List<String> Mydata1 = new ArrayList<String>();
		 FileInputStream filepath = new FileInputStream("C:\\Users\\2389291\\OneDrive - Cognizant\\Desktop\\hackathonProject\\src\\test\\resources\\HackathonExcelInput1.xlsx");
		// fi =new FileInputStream(path);
		workbook = new XSSFWorkbook(filepath);
		sheet = workbook.getSheet("Sheet2");
		for (int i = 1; i <= 4; i++) {
			DataFormatter format = new DataFormatter();
 			String cellData = format.formatCellValue(sheet.getRow(i).getCell(1));
  			Mydata1.add(cellData);
		}
		filepath.close();
		workbook.close();
		return Mydata1;
	}
	
	public static String CityName() throws IOException {
 		String cityname;
		FileInputStream filepath = new FileInputStream("C:\\Users\\2389291\\OneDrive - Cognizant\\Desktop\\hackathonProject\\src\\test\\resources\\HackathonExcelInput2.xlsx");
		// fi =new FileInputStream(path);
		workbook = new XSSFWorkbook(filepath);
		sheet = workbook.getSheet("cityname");
		 
			DataFormatter format = new DataFormatter();
 		    cityname = format.formatCellValue(sheet.getRow(0).getCell(0));
	
		filepath.close();
		workbook.close();
		return cityname;
	}
}
