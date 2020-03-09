package My_Project;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DATA {


	public static void main(String[] args) throws IOException {
		String arr[][] = null;
		  int i=0,j=0;
		  String s;
		  int n;
		  
		  File file=new File("C:\\latest\\latest\\Automation\\HotelsData.xlsx");
			FileInputStream fis=new FileInputStream(file);
			@SuppressWarnings("resource")
			XSSFWorkbook workbook=new XSSFWorkbook(fis);
			XSSFSheet sheet=workbook.getSheet("HotelDetails");
			Iterator <Row> itr=sheet.iterator();
		
		 
			while(itr.hasNext())
			{
				
				Row row=itr.next();
				Iterator<Cell> cellIterator=row.cellIterator();
				while(cellIterator.hasNext()) 
				{
					Cell cell=cellIterator.next();
					switch(cell.getCellType())
					{
					case STRING:
						s=cell.getStringCellValue();
						data[i][j]=s;
						break;
					case NUMERIC:
						n=(int) cell.getNumericCellValue();
						data[i][j]=n;
					    break;
					default:
					}
					

					System.out.print(" \t"+cell.getStringCellValue());
					
				    j++;
				}System.out.println(" ");
				i++;
			}
			

	}

}
