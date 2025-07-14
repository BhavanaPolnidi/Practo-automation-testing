package Utills;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import PageObjectClass.Diagnostic_page;
import PageObjectClass.HomePage;

 
public class ExcelOuputUtils {

	public static void ExcelOutputData1() throws IOException 
	{
	 List<String>topcities=Diagnostic_page.listoftopcities;
	 FileOutputStream filepath =new FileOutputStream(".//FileOutputData//Fileoutput1.xlsx");
     XSSFWorkbook workbook=new XSSFWorkbook();
     XSSFSheet sheet1=workbook.createSheet("List of Top Cities");
     XSSFRow row=sheet1.createRow(0);
     row.createCell(0).setCellValue("List Of Top Cities");
     for(int i=0;i<topcities.size();i++)
     {
    	 sheet1.createRow(i+1).createCell(0).setCellValue(topcities.get(i));
     }
      workbook.write(filepath);
     filepath.close();
     workbook.close();
 	}
	
	public static void ExcelOutputData2() throws IOException 
	{
	 List<String> hospitallist24Parking=HomePage.hospitalList2;
	 FileOutputStream filepath =new FileOutputStream(".//FileOutputData//Fileoutputwithcities.xlsx");
     XSSFWorkbook workbook=new XSSFWorkbook();
     XSSFSheet sheet1=workbook.createSheet("Cities With 24x7 and Parking");
     XSSFRow row=sheet1.createRow(0);
     row.createCell(0).setCellValue("List of Hospital");
     for(int i=0;i<hospitallist24Parking.size();i++)
     {
    	 sheet1.createRow(i+1).createCell(0).setCellValue(hospitallist24Parking.get(i));
     }
      workbook.write(filepath);
     filepath.close();
     workbook.close();
 	}
	
	
}
