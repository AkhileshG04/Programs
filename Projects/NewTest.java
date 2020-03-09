package My_Project;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class NewTest {
	int i=0;
  @Test(dataProvider = "dp")
  public void a(String n,String s) throws InterruptedException {
	  System.out.println("String 1 :"+n+"\tString 2 :"+s);
	  i++;
		
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Before");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("After");
  }


  @DataProvider
  public Object[][] dp() throws IOException {
    
	  Object[][] data =new Object[3][2];
	  
	  String obj;
	   
	 int j=0;
	  
	  File file=new File("C:\\latest\\latest\\Automation\\Sample.xlsx");
		FileInputStream fis=new FileInputStream(file);

		@SuppressWarnings("resource")
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("Sample");
		Iterator <Row> itr=sheet.iterator();
	
	 
		
			
			Row row=itr.next();
			Iterator<Cell> cellIterator=row.cellIterator();
		while(j<2)
		{
				Cell cell=cellIterator.next();
				
				obj=(cell.getStringCellValue());
				data[i][j]=obj;
				j++;
						
		}
		return data;
    	

	  
	  
  }
  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

}
