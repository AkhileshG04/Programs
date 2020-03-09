package My_Project;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadF {

	public static void main(String args[]) throws IOException {
		
		File file=new File("C:\\latest\\latest\\Automation\\HotelsData.xlsx");
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("HotelDetails");
		Iterator <Row> itr=sheet.iterator();
		while(itr.hasNext()){
			Row row=itr.next();
			Iterator<Cell> cellIterator=row.cellIterator();
			while(cellIterator.hasNext()) {
				Cell cell=cellIterator.next();
				switch(cell.getCellType())
				{
				case STRING:
					System.out.print(cell.getStringCellValue() + "\t");
					break;
				case NUMERIC:
					System.out.print(cell.getNumericCellValue() + "\t");
				    break;
				default:
				}
				
			}
			System.out.println("");
		}
		workbook.close();
	
		
	}


}
