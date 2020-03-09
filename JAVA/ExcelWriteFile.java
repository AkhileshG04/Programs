package Basics;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFEvaluationWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriteFile {

	public static void main(String[] args) {
		
		try
		{
			File file = new File("C:\\Users\\837357\\Documents\\Java\\Excel.xlsx");
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = (XSSFSheet) wb.getSheetAt(0);
			Iterator <Row> itr = sheet.iterator();
			while(itr.hasNext())
			{
				Row row = itr.next();
				Iterator<Cell> cellItreator = row.cellIterator();
				while(cellItreator.hasNext())
				{
					Cell cell = cellItreator.next();
					switch(cell.getCellType())
					{
					case STRING : System.out.println(cell.getStringCellValue()+"\t\t\t");
									break;
					case NUMERIC : System.out.println(cell.getStringCellValue()+"\t\t\t");
					                break;
					default: System.out.println("");
					                                                                                                                             
					
					}
				}
			}
		}
	}

}
