package My_Project;

import org.testng.annotations.Test;

import com.graphbuilder.curve.Point;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class RedBus_Final {
	WebDriver driver;
	int i,count,f=0,m;
	String t;
	Actions a;
@Test(dataProvider = "dp")
  public void f(String startLocation,String endLocation,String sMonth,String sDay) throws InterruptedException {
	  
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  
	    System.out.println(""+startLocation+"\n"+endLocation+"\n"+sMonth+"\n"+sDay);
	  
	//From	
	driver.findElement(By.id("src")).sendKeys(startLocation);
	driver.findElement(By.xpath("//*[@class=\"autoFill\"]//*"));
	//To
	driver.findElement(By.id("dest")).sendKeys(endLocation);
	driver.findElement(By.xpath("//*[@class=\"autoFill\"]//*")).click();
	
	//Start Date
	driver.findElement(By.xpath("//*[@class=\"db text-trans-uc move-up\"]")).click();
	
    //Selecting Start Month	
	WebElement startMonth=driver.findElement(By.xpath("//*[@class=\"rb-calendar\"]//*[@class=\"monthTitle\"]"));
	WebElement startNextButton=driver.findElement(By.xpath("//*[@class=\"rb-calendar\"]//*[@class=\"next\"]"));
	
		 
	  while(!(startMonth.getText().contains(sMonth)))
	   {
		  
		  startNextButton.click();
		  startMonth=driver.findElement(By.xpath("//*[@class=\"rb-calendar\"]//*[@class=\"monthTitle\"]"));
		  startNextButton=driver.findElement(By.xpath("//*[@class=\"rb-calendar\"]//*[@class=\"next\"]"));
		 
	   }
	
	  //Selecting Start day
	  
      List<WebElement> startDate = driver.findElements(By.xpath("//*[@class=\"rb-calendar\"]//*[@class=\"wd day\" or @class=\"we day\"]"));
	
   	    count=startDate.size();
	
	    for(i=0;i<count;i++)
	    {
		  t=(startDate).get(i).getText();
	  
	      if(t.equalsIgnoreCase(sDay))
	       {
	    	  startDate.get(i).click();
		     break;
	        }
	     }
	    
//	   driver.findElement(By.xpath("//*[@class=\"db text-trans-uc tal\"]")).click();
//	    
//	  //Selecting End Month	
//	  WebElement endMonth=driver.findElement(By.xpath("//*[@class=\"rb-calendar\"]//*[@class=\"monthTitle\"]"));
//	  WebElement endNextButton=driver.findElement(By.xpath("//*[@class=\"rb-calendar\"]//*[@class=\"next\"]"));
//			 
//		  while(!(endMonth.getText().contains("Dec 2020")))
//		   {
//			  
//			  endNextButton.click();
//			  endMonth=driver.findElement(By.xpath("//*[@class=\"rb-calendar\"]//*[@class=\"monthTitle\"]"));
//			  endNextButton=driver.findElement(By.xpath("//*[@class=\"rb-calendar\"]//*[@class=\"next\"]"));
//			 
//		   }
//		
//		  //Selecting End day
//		  
//	      List<WebElement> endDate = driver.findElements(By.xpath("//*[@class=\"rb-calendar\"]//*[@class=\"wd day\" or @class=\"we da\"]"));
//		
//	   	    count=endDate.size();
//		
//		    for(i=0;i<count;i++)
//		    {
//			  t=(endDate).get(i).getText();
//		  
//		      if(t.equalsIgnoreCase("20"))
//		       {
//		    	  endDate.get(i).click();
//			     break;
//		        }
//		     }
	    //Clicking Search Button
	    driver.findElement(By.id("search_btn")).click();
	    
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    
	    try
	    {
	    	List <WebElement> p = driver.findElements(By.xpath("//*[@class=\"s-buses m-top-10 button\"]"));
	    	p.get(0);
	    }catch(Exception e)
	    {
	    	
	    }
	    
	  List <WebElement> fare = driver.findElements(By.xpath("//*[@class=\"f-19 f-bold\"]"));
	  List <WebElement> seat = driver.findElements(By.xpath("//*[@class=\"button view-seats fr\"]"));

		  int min = Integer.parseInt(fare.get(0).getText());
	
		  count=fare.size();
		  System.out.println("Count: "+count);
		  for(int i=0;i<count;i++)
		   {
			  m=Integer.parseInt(fare.get(i).getText());
			  if(m<min)
			  {
				  min=Integer.parseInt(fare.get(i).getText());
				  f=i;
			  }
		   }
		  System.out.println("Fare : "+min+"\n"+(f));
		  seat.get(f).click();
		 
	    WebElement canvas = driver.findElement(By.xpath("//*[@class=\"lower-canvas canvas-wrapper\"]/canvas"));
	  
	    Thread.sleep(5000L);
	    
	    
	    
	    //Boarding Point
	    try {   	
	    	 List <WebElement> boardingPointList = driver.findElements(By.xpath("//*[@class=\"modal-body oa-y\"]//*[@class=\"db oh\"]"));
			    boardingPointList.get(1).click();
//	    	WebElement startCheck=driver.findElement(By.xpath("//*[@class=\"radio-checked\"]"));
	    }catch(Exception e)
	    {
		   
	    }
	    //Dropping Point
	    try {
	    	List <WebElement> droppingPointList = driver.findElements(By.xpath("//*[@class=\"modal-body oa-y\"]//*[@class=\"db oh\"]"));
	    	droppingPointList.get(0).click();
//	    	WebElement endCheck = driver.findElement(By.xpath("//*[@class=\\\"radio-checked\\\"]"));
	    }catch(Exception e)
	    {

	    }
	   

	    Thread.sleep(2000L);
	    
	    driver.findElement(By.xpath("//*[@class=\"continue-container w-100 fl m-b-10\"]/button")).click();
	    
	    Thread.sleep(2000L);
	    
	    driver.findElement(By.id("seatno-04")).sendKeys("Akhilesh");
	    
	    driver.findElement(By.xpath("//*[@class=\"custinfo_label\"]//*[@id=\"seatno-01\"]")).sendKeys("22");
	    
	    driver.findElement(By.id("seatno-05")).sendKeys("example@gmail.com");
	    
	    driver.findElement(By.id("seatno-06")).sendKeys("8459655482");
	    
//	    List <WebElement> gender = driver.findElements(By.xpath("//*[@class=\"radio_container clearfix\"]//*[@type=\"radio\"]"));
//	    gender.get(0).click();
	    
	    driver.findElement(By.xpath("//*[@id=\"div_22_0\"]")).click();
	    	   	    
	    driver.findElement(By.xpath("//*[@id=\"insuranceTNC\"]")).click();
	    
	    driver.findElement(By.xpath("//*[@class=\"button-container fr\"]/input")).click();
	    
	    //Payment Window
	    
	    driver.findElement(By.id("DCARDNO")).sendKeys("45600266219906220");
	    
	    Select month = new Select(driver.findElement(By.id("DebitCardEXPMONTH")));
	    month.selectByVisibleText("Apr (04)");
	    
	    Select year = new Select(driver.findElement(By.id("DebitCardEXPYEAR")));
	    year.selectByVisibleText("2025");
	    
	    driver.findElement(By.id("DCVV")).sendKeys("364");
	  
	    driver.findElement(By.id("DCARD_HOLDER_NAME")).sendKeys("Akhilesh");
	    
	    driver.findElement(By.id("makepayment")).click();
  
  }
	  
  
  @BeforeMethod
  public void beforeMethod() {
	  
ChromeOptions options = new ChromeOptions();
options.addArguments("--disable-notifications");	  
System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
driver = new ChromeDriver(options);
driver.get("https://www.redbus.in/");
driver.manage().window().maximize();



  }

@AfterMethod
  public void afterMethod() throws IOException {
	 TakesScreenshot scrn = ((TakesScreenshot)driver);
	 File src = scrn.getScreenshotAs(OutputType.FILE);
	 String i="imgFailRedbus";
	 File dest = new File("C:\\latest\\latest\\Screenshots"+i+System.currentTimeMillis()+".png");
	 FileUtils.copyFile(src, dest);
	 driver.quit();
		
	  
  }



@DataProvider(name="dp")
public Object[][] dp() throws IOException {
  int i=0,j=0;
  String obj;
  Object[][] data= new Object[3][4];
	  File file=new File("C:\\latest\\latest\\Automation\\RedBusData.xlsx");
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("RedBusData");
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

