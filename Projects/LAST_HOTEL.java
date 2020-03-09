package My_Project;

import org.testng.annotations.Test;



import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class LAST_HOTEL {
	WebDriver driver;
	Iterator<WebElement> it;
	WebElement d,day,d1,check;
	Actions a1;
	List<WebElement> l,p1;
	
@Test(dataProvider = "dp")
  public void f(String city,String checkin,String inmonth,String checkout,String outmonth) throws InterruptedException {
	
    driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
	  
	//Pop-Up Management
    driver.findElement(By.xpath("//*[@id=\"managed-overlay\"]/div/div/div[4]/div/div/div/div/a")).click();

//	Thread.sleep(5000L);
	System.out.println(" "+city+"\n"+checkin+"\n"+inmonth+"\n"+checkout+"\n"+outmonth);
	
     //Destination Picker
	 driver.findElement(By.xpath("//*[@id=\"qf-0q-destination\"]")).sendKeys(city);

	 Thread.sleep(5000L);
     //Select Destination from DropDown
	 driver.findElement(By.xpath("//*[@id=\"citysqm-asi0-s0\"]/td")).click();
	
     //Clicking Date Box
	 driver.findElement(By.xpath("//*[@id=\"qf-0q-localised-check-in\"]")).click();
	 

	 int count,i;
	 String text;

	 List<WebElement> p;

//	 Start Month
	 d=driver.findElement(By.xpath("//*[@class=\"widget-datepicker-hd\"]//*[@class=\"widget-datepicker-label\"]"));
	 while(!d.getText().contains(inmonth))
	 {
		 p = (List<WebElement>) driver.findElements(By.xpath("//*[@class=\"widget-datepicker-hd\"]/button[2]"));
		 ((List<WebElement>) p).get(1).click();
	 }
	 
//	Start Day 
 
	 List<WebElement> dates =  driver.findElements(By.xpath("/html/body/div[6]/div[2]/div[1]/div[2]/table/tbody/tr/td/a"));
	  
	  count = dates.size();
	  
	  System.out.println(count);

	  for(i=0;i<count;i++)
	  {
		  text=dates.get(i).getText();
	       if(text.equalsIgnoreCase(checkin))
	        {
		      dates.get(i).click();
		      break;
	        }
	  }
	
	  driver.findElement(By.xpath("//*[@id=\"qf-0q-localised-check-out\"]")).click();
	  
//		 End Month
		 d=driver.findElement(By.xpath("//*[@class=\"widget-datepicker-hd\"]//*[@class=\"widget-datepicker-label\"]"));
		 while(!d.getText().contains(outmonth))
		 {
			 p = (List<WebElement>) driver.findElements(By.xpath("//*[@class=\"widget-datepicker-hd\"]/button[2]"));
			 ((List<WebElement>) p).get(1).click();
		 }
		 
//		End Day 
	 
		 List<WebElement> date =  driver.findElements(By.xpath("/html/body/div[6]/div[2]/div[1]/div[2]/table/tbody/tr/td/a"));
		  
		  count = date.size();
		  
		  for(i=0;i<count;i++)
		   {
			  text=date.get(i).getText();
	     	  if(text.equalsIgnoreCase(checkout))
	     	  {
			   date.get(i).click();
			   break;
	     	  }
		   }	 
		  
//Clicking Search		  
driver.findElement(By.xpath("//*[@id=\"hds-marquee\"]/div[2]/div[1]/div/form/div[4]/button")).click();

driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

//Selecting Rooms	  
 Select s1=new Select(driver.findElement(By.xpath("//*[@id=\"q-rooms\"]")));
 s1.selectByVisibleText("2");
 
//Selecting Adults
 Select s2=new Select(driver.findElement(By.xpath("//*[@id=\"q-room-0-adults\"]")));
 s2.selectByVisibleText("2");
 
 //Selecting Children
 Select s3=new Select(driver.findElement(By.xpath("//*[@id=\"q-room-0-children\"]")));
 s3.selectByVisibleText("0");
 
 //Choosing Rooms
// List<WebElement> lil = driver.findElements(By.xpath("//*[@id=\"listings\"]/ol/li/article/section/aside/a"));
// lil.get(1).click();
// 
 WebElement cho;
try {
//Choosing Room
	List<WebElement> choose =driver.findElements(By.xpath("//*[@class=\"hotel sponsored\"]/article/section/aside/a"));
	cho=choose.get(0);
	cho.click();
}
catch(Exception e)
{
	List<WebElement> choose =driver.findElements(By.xpath("//*[@class=\"hotel-wrap\"]/aside/a"));
	cho=choose.get(1);
	cho.click();
}
// driver.findElement(By.xpath("//*[@id=\"rooms-and-rates.room-1-rateplan-1\"]/button")).click();
 
//Switching Windows
ArrayList<String> availableWindows = new ArrayList<String>(driver.getWindowHandles());
driver.switchTo().window(availableWindows.get(1));  


driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);


driver.findElement(By.xpath("//*[@id=\"book-now-button\"]")).click();
Thread.sleep(2000L);


//Book Now Button
List <WebElement> yuq= driver.findElements(By.xpath("//*[@class=\"cta-wrap\"]/form/button"));
Thread.sleep(2000L);


WebElement op =yuq.get(1);
op.click();
Thread.sleep(2000L);

//Dealing PopUp
try
{
if((driver.findElements(By.xpath("//*[@id=\"pay-now-etp-form\"]//*[@type=\"submit\" and @class=\"cta\"]")))!=null)
{

	driver.findElement(By.xpath("//*[@id=\"pay-now-etp-form\"]//*[@type=\"submit\" and @class=\"cta\"]")).click();
}
}catch(Exception e)
{}

driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

//Payment Credentials
driver.findElement(By.xpath("//*[@id=\"room-details-room-0-first-name\"]")).sendKeys("Varun");
		
driver.findElement(By.xpath("//*[@id=\"room-details-room-0-last-name\"]")).sendKeys("Narayanan");
		
driver.findElement(By.xpath("//*[@id=\"contact-details-email\"]")).sendKeys("Varunnarayanan@gmail.com");

driver.findElement(By.xpath("//*[@id=\"contact-details-phone\"]")).sendKeys("852649585");

Select g1 =new Select(driver.findElement(By.xpath("//*[@id=\"payment-details-card-type-selector\"]")));
g1.selectByVisibleText("Visa");


driver.findElement(By.xpath("//*[@id=\"payment-details-card-number\"]")).sendKeys("4500850065221995");
		
driver.findElement(By.xpath("//*[@id=\"expiry-month\"]")).sendKeys("04");

driver.findElement(By.xpath("//*[@id=\"expiry-year\"]")).sendKeys("23");

driver.findElement(By.xpath("//*[@id=\"payment-details-cvv\"]")).sendKeys("365");  Thread.sleep(2000L);

driver.findElement(By.xpath("//*[@id=\"book-button\"]")).click();



	  
  }
  @BeforeMethod
  public void beforeTest() {
	  
	  System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get("https://in.hotels.com/");
	  driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterTest() throws IOException {

	  JavascriptExecutor js = (JavascriptExecutor) driver;
      js.executeScript("window.scrollBy(0,-600)", "");
	  
	  TakesScreenshot scrn = ((TakesScreenshot)driver);
		 File src = scrn.getScreenshotAs(OutputType.FILE);
		 String i="imgFail";
		 File dest = new File("C:\\latest\\latest\\Screenshots\\"+i+System.currentTimeMillis()+".png");
		 FileUtils.copyFile(src, dest);
		 driver.quit();
		
		
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

