package My_Project;

import org.testng.annotations.Test;



import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class DataDrivenHotels {
	WebDriver driver;
	Iterator<WebElement> it;
	WebElement d,day,d1,check;
	Actions a1;
	List<WebElement> l,p1;
	
  @Test(dataProvider = "dp")
  public void a(String cityName,String checkinday ,String checkinMY ,String checkout,String checkoutMY) throws InterruptedException {
	

	  System.out.println("CityName:"+cityName+"\nCheckInday:"+checkinday+"\nCheckInMY :"+checkinMY+"\nCheckoutMY:"+checkoutMY);
		
//		 driver.findElement(By.xpath("//*[@id=\"qf-0q-destination\"]")).click();
		 driver.findElement(By.xpath("//*[@id=\"qf-0q-destination\"]")).sendKeys(cityName);
//		 driver.findElement(By.xpath("//*[@id=\"qf-0q-destination\"]")).sendKeys(Keys.ENTER);
		 Thread.sleep(2000L);

		 driver.findElement(By.xpath("//*[@id=\"citysqm-asi0-s0\"]/td")).click();
		 Thread.sleep(2000L);
		 
//		 Thread.sleep(2000L);
//		 driver.findElement(By.xpath("//*[@class=\"cta cta-link\"]")).click();
//		 Thread.sleep(2000L);
		 
//		 driver.findElement(By.xpath("//*[@class=\"aria-label\" and @data-input=\"qf-0q-localised-check-in\"]")).clear();
		
//		driver.findElement(By.xpath("//*[@id=\"citysqm-asi0-s0\"]/td")).click();
//		  driver.findElement(By.xpath("//*[@id=\"qf-0q-destination\"]")).click();
//		     	  
//		driver.findElement(By.xpath("//*[@id=\"recommendedsqm-asi0-s0\"]/td/div[1]/span")).click();
	//	
		 
		 driver.findElement(By.xpath("//*[@id=\"qf-0q-localised-check-in\"]")).click();
		 Thread.sleep(2000L);


		 int count,coun,i;
		 String text;

		 List <WebElement> c1 = driver.findElements(By.xpath("//*[@class=\"widget-query-date\"]/label[2]"));

		
		 it=c1.iterator();
		 WebElement a=it.next();
		 a.click();
		 
		 Thread.sleep(2000L);

		 List<WebElement> p;

//		 Start Month
		 d=driver.findElement(By.xpath("//*[@class=\"widget-datepicker-hd\"]//*[@class=\"widget-datepicker-label\"]"));
		 while(!d.getText().contains(checkinMY))
		 {
			 p = (List<WebElement>) driver.findElements(By.xpath("//*[@class=\"widget-datepicker-hd\"]/button[2]"));
			 ((List<WebElement>) p).get(1).click();
		 }
		 
//		Start Day 
	 
		 List<WebElement> dates =  driver.findElements(By.xpath("/html/body/div[6]/div[2]/div[1]/div[2]/table/tbody/tr/td/a"));
		  
		  count = dates.size();
		  
		  System.out.println(count);

		  for(i=0;i<count;i++)
		  {
			  text=dates.get(i).getText();
		
			  
		  
		  if(text.equalsIgnoreCase(checkinday))
		  {
			  dates.get(i).click();
			  break;
		  }
		  }
		  
		  driver.findElement(By.xpath("//*[@id=\"widget-query-label-3\"]")).click();

////			 End Month   
////		     List<WebElement> yui=driver.findElements(By.xpath("//*[@class=\"widget-datepicker-hd\"]//*[@class=\"widget-datepicker-label\"]"));
////		     WebElement q =driver.findElement(By.xpath("/html/body/div[6]/div[2]/div[1]/div[1]/div"));
////		     WebElement q =driver.findElement(By.xpath("/html/body/div[6]/div[2]/div[1]/div[1]/div"));
////	         List<WebElement> opi=driver.findElements(By.xpath("//*[@class=\"widget-datepicker-next\" and @type=\"button\"]"));
////	         WebElement eday=opi.get(1);
//	    	 WebElement q=driver.findElement(By.xpath("//*[@class=\"widget-datepicker-hd\"]//*[@class=\"widget-datepicker-label\"]"));
	//
//			 while(!(q.getText().contains("September 2020")))
//			 {
////				eday.click();
//				 p = (List<WebElement>) driver.findElements(By.xpath("//*[@class=\"widget-datepicker-hd\"]/button[2]"));
//				 ((List<WebElement>) p).get(1).click();
//			 }
	//
////			End Day 
//				 
//			 List<WebElement> date =  driver.findElements(By.xpath("/html/body/div[6]/div[2]/div[2]/div[2]/table/tbody/tr/td/a"));
//			  
//			  coun = date.size();
//			  
//			  System.out.println(coun);
	//
//			  for(i=0;i<coun;i++)
//			  {
//				  text=date.get(i).getText();
//				  		
//				  
//			  
//			  if(text.equalsIgnoreCase("3"))
//			  {
//				  date.get(i).click();
//				  break;
//			  }
//			  }
		  
//			 Start Month
			 d=driver.findElement(By.xpath("//*[@class=\"widget-datepicker-hd\"]//*[@class=\"widget-datepicker-label\"]"));
			 while(!d.getText().contains(checkoutMY))
			 {
				 p = (List<WebElement>) driver.findElements(By.xpath("//*[@class=\"widget-datepicker-hd\"]/button[2]"));
				 ((List<WebElement>) p).get(1).click();
			 }
			 
//			Start Day 
		 
			 List<WebElement> date =  driver.findElements(By.xpath("/html/body/div[6]/div[2]/div[1]/div[2]/table/tbody/tr/td/a"));
			  
			  count = date.size();
			  
			  System.out.println(count);

			  for(i=0;i<count;i++)
			  {
				  text=date.get(i).getText();
			
				  
			  
			  if(text.equalsIgnoreCase(checkout))
			  {
				  date.get(i).click();
				  break;
			  }
			  }	  
	 
		  
	 driver.findElement(By.xpath("//*[@id=\"hds-marquee\"]/div[2]/div[1]/div/form/div[4]/button")).click();
		  
	 Select s1=new Select(driver.findElement(By.xpath("//*[@id=\"q-rooms\"]")));
	 s1.selectByVisibleText("2");

	 Select s2=new Select(driver.findElement(By.xpath("//*[@id=\"q-room-0-adults\"]")));
	 s2.selectByVisibleText("2");
	 
	 Select s3=new Select(driver.findElement(By.xpath("//*[@id=\"q-room-0-children\"]")));
	 s3.selectByVisibleText("0");
	 
	 List<WebElement> lil = driver.findElements(By.xpath("//*[@id=\"listings\"]/ol/li/article/section/aside/a"));
	 lil.get(1).click();
	 
	 
	//driver.findElement(By.xpath("//*[@id=\"listings\"]/ol/li[2]/article/section/aside/a")).click();

	ArrayList<String> availableWindows = new ArrayList<String>(driver.getWindowHandles());
	driver.switchTo().window(availableWindows.get(1));  

	driver.findElement(By.xpath("//*[@id=\"book-now-button\"]")).click();
	Thread.sleep(2000L);

	driver.findElement(By.xpath("//*[@id=\"rooms-and-rates.room-1-rateplan-1\"]/button")).click();

	//List <WebElement> pop = driver.findElements(By.xpath("/html/body/div[15]"));
	//if(pop.size()!=0)
	//{	
	driver.findElement(By.xpath("//*[@id=\"pay-now-etp-form\"]/button")).click();
	//}	

	Thread.sleep(5000L);

	driver.findElement(By.xpath("//*[@id=\"room-details-room-0-first-name\"]")).sendKeys("Varun");
			
	driver.findElement(By.xpath("//*[@id=\"room-details-room-0-last-name\"]")).sendKeys("Narayanan");
			
	driver.findElement(By.xpath("//*[@id=\"contact-details-email\"]")).sendKeys("Varunnarayanan@gmail.com");

	driver.findElement(By.xpath("//*[@id=\"contact-details-phone\"]")).sendKeys("852649585");

	Select g1 =new Select(driver.findElement(By.xpath("//*[@id=\"payment-details-card-type-selector\"]")));
	g1.selectByVisibleText("Visa");


	driver.findElement(By.xpath("//*[@id=\"payment-details-card-number\"]")).sendKeys("4500850065221995");
			
	driver.findElement(By.xpath("//*[@id=\"expiry-month\"]")).sendKeys("04");

	driver.findElement(By.xpath("//*[@id=\"expiry-year\"]")).sendKeys("23");

	driver.findElement(By.xpath("//*[@id=\"payment-details-cvv\"]")).sendKeys("365");

	driver.findElement(By.xpath("//*[@id=\"book-button\"]")).click();



		  
  }
  @BeforeMethod
  public void beforeMethod() {
	  
		  System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		  driver = new ChromeDriver();
		  driver.get("https://in.hotels.com/");
		  driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() throws IOException {
	  TakesScreenshot scrn = ((TakesScreenshot)driver);
		 File src = scrn.getScreenshotAs(OutputType.FILE);
		 String i="imgFail";
		 File dest = new File("C:\\latest\\latest\\Screenshots\\"+i+System.currentTimeMillis()+".png");
		 FileUtils.copyFile(src, dest);
//		 driver.quit();
		 
  }


 
@DataProvider(name="dp")
  public Object[][] dp() throws IOException  {
	  
	  
	  Object[][] data = new Object[3][5];

	  String s;
				  
	  int i=0,j=0,n;
	  
	  File file=new File("C:\\latest\\latest\\Automation\\HotelsData.xlsx");
		FileInputStream fis=new FileInputStream(file);

		@SuppressWarnings("resource")
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("HotelDetails");
		Iterator <Row> itr=sheet.iterator();
	
	 
		while(itr.hasNext()){
			j=0;
			Row row=itr.next();
			Iterator<Cell> cellIterator=row.cellIterator();
			
			while(cellIterator.hasNext()) {
				
				Cell cell=cellIterator.next();
				
					s=cell.getStringCellValue();
					data[i][j]=s;
					
			  j++;
			}
//			System.out.println(" "+i+" "+j);
//System.out.println(" "+j);
//			System.out.println("");
			i++;
		}
		
	 return data; 
  }  
	 
 

  @BeforeTest
  public void beforeTest() {
	 System.out.println("Test Starts");
  }

  @AfterTest
  public void afterTest() throws IOException {
	  System.out.println("Test Ends");
  }
 
}
