package My_Project;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class Excel {

	public static void main(String args[]) throws IOException {
		int i=0,j=0;
		String s;
		String[][] arr=new String[3][2];
		File file=new File("C:\\latest\\latest\\Automation\\FbLogin.xlsx");
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("qqq");
		Iterator <Row> itr=sheet.iterator();
		
		while(itr.hasNext()){
			j=0;
			Row row=itr.next();
			Iterator<Cell> cellIterator=row.cellIterator();
			
			while(cellIterator.hasNext()) {
				
				Cell cell=cellIterator.next();
				
					s=cell.getStringCellValue() ;
//					System.out.println(" "+cell.getStringCellValue());
//					System.out.println(" "+i+" "+j);
					arr[i][j]=s;
				
				
				
				j++;
			}
//			System.out.println(" "+i+" "+j);
//System.out.println(" "+j);
			System.out.println("");
			i++;
		}
		
	
		workbook.close();
	for(int m=0;m<3;m++)
	{
		for(int n=0;n<2;n++)
		{
			System.out.print(" "+(arr[m][n]));
		}
		System.out.println("");
	}
		
	}


}
