package Hotels;

import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class Hotels_Test extends Test_Base {
  @Test(dataProvider = "dp")
  public void f(String city,String checkin,String inmonth,String checkout,String outmonth) throws InterruptedException {
	
	  Search_Page s =new Search_Page(driver);
	  
	  driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);

	  s.place(city);
	  s.Checkindate(inmonth, checkin);
	  s.Checkoutdate(outmonth, checkout);
	  s.submit();
	  
	  Choose_Room c = new Choose_Room(driver);
	  
	  c.chooseRoom();
	  
	  ArrayList<String> availableWindows = new ArrayList<String>(driver.getWindowHandles());
	  driver.switchTo().window(availableWindows.get(1));  
	  
	  c.BookNow();
	  c.Popup();
	  
	  Payment p = new Payment(driver);
	  
	  p.PersonalDetails();
	  p.CardDetails();
	  p.Book();
			  
	  
  }

  @DataProvider
  public Object[][] dp() throws IOException {
	  int i=0,j=0;
	    String obj;
	    Object[][] data= new Object[12][5];
		  File file=new File("C:\\latest\\latest\\Automation\\HotelsData.xlsx");
			FileInputStream fis=new FileInputStream(file);
			XSSFWorkbook workbook=new XSSFWorkbook(fis);
			XSSFSheet sheet=workbook.getSheet("HotelDetails");
			Iterator <Row> itr=sheet.iterator();
			while(itr.hasNext()){
				j=0;
				Row row=itr.next();
				Iterator<Cell> cellIterator=row.cellIterator();
				while(cellIterator.hasNext()) {
					Cell cell=cellIterator.next();
					
						obj=cell.getStringCellValue();
						data[i][j]=obj;
				j++	;
				}
				i++;
			}
			workbook.close();
			return data;
  }
}
