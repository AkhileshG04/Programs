package com.bmw.pages;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWrite {
	public static Object[][] data = new Object[5][2];
	
	public static void ObjData(int RowC,int ColC,String s)
	{
		data[RowC][ColC]=s;
	}
	
	public static void Write() {
       data[0][0]="OUTPUT POWER";
       data[0][1]="Result";
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("BMW_OUTPUT");
		
		int rowCount=0;
		for(Object[] abc : data)
		{
			Row row = sheet.createRow(rowCount++);
		int colCount=0;
		for(Object fie : abc)
		{
			Cell cell = row.createCell(colCount++);
		if(fie instanceof String)
		{
			cell.setCellValue((String) fie);
		}
		else if (fie instanceof Integer)
		{
			cell.setCellValue((Integer) fie);
		}
		else if(fie instanceof Float)
		{
			cell.setCellValue((Float) fie);
		}
	}

}
		try
		{
			File file = new File("C:\\latest\\latest\\Automation\\BMW_Output.xlsx");
			FileOutputStream fis = new FileOutputStream(file);
			workbook.write(fis);
			workbook.close();
			System.out.println("File has been written successfully");
					}
		catch(Exception e)
		{
		e.printStackTrace();	
		}
		}

}    
	  

