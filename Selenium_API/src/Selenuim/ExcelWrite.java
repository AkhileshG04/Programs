package Selenuim;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWrite {

	public static void main(String[] args) {
		
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Student_Marks");
		
		Object[][] object = {
				{"Roll No","Student Name","Avg Marks"},
				{2001,"ABC",78.23f},
				{2002,"DEF",61.87f},
				{2003,"GH",43.57f},
		};
   
		int rowCount = 0;
		
			for(Object[] aBook:object) {
				Row row = sheet.createRow(rowCount++);
			
			int columnCount = 0;
			
			for(Object field : aBook) {
				Cell cell = row.createCell(columnCount++);
				
				if(field instanceof String) {
					cell.setCellValue((String)field);
				}
				else if (field instanceof Integer)
				{
					cell.setCellValue((Integer)field);
				}
				else if (field instanceof Float)
				{
					cell.setCellValue((Float)field);
				}
				}
			}
			try {
				File file =new File("C:\\Users\\837357\\Documents\\Write.xlsx");
				FileOutputStream fis = new FileOutputStream(file);
				workbook.write(fis);
				
				workbook.close();
				System.out.println("File has been Written");
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
	}
	
}