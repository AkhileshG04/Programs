package Selenuim;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xslf.usermodel.XSLFSheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {

	public static void main(String[] args) {
		
		File f=new File();
		FileInputStream fis=new FileInputStream(f);
		XSSFWorkbook wb =new XSSFWorkbook();
		XSSFSheet ws = wb.getSheet("");
		
		
		
		while(itr.hasNext())
		{
			Row row =itr.next();
			Itreator<Cell> cellItreator = row.cellIterator();
			while(cellItreator.hasNext())
			{
				
			Cell cell = cellItreator.nect();
			
			switch(cell.getCellType())
			{
			case STRING : 
				System.out.println(cell.getStringCellValue());
				break;
				
			case NUMERIC :
				System.out.println(cell.getNumericCellValue());
				break;
			}
			
		}
		}

}
