package TestNG;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.List;

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
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Template {

	public static void main(String[] args) {
		System.out.println("Template");
		
		
//-----------------------------------------Launch Chrome Browser----------------------------------------------------------------
		
	  WebDriver driver;
      System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get("https://www.seleniumhq.org");
	  driver.manage().window().maximize();
		  
//------------------------------------------Launch IE Browser--------------------------------------------------------------------
	  
		WebDriver driver;
	   System.setProperty("webdriver.ie.driver", "C:\\Selenium\\IEDriverServer_x64_3.14.0\\IEDriverServer.exe");
	   driver = new InternetExplorerDriver();
	   driver.get("https://in.hotels.com/");
	   driver.manage().window().maximize();
		  
		  
//-----------------------------------------------Screenshot----------------------------------------------------------------------
	   
		TakesScreenshot scrn = ((TakesScreenshot)driver);
	    File src = scrn.getScreenshotAs(OutputType.FILE);
	    String i="imgFail";
	    File dest = new File("C:\\latest\\latest\\Screenshots\\"+i+System.currentTimeMillis()+".png");
	    FileUtils.copyFile(src, dest);
		driver.close();
		
//-----------------------------------------------Month Select------------------------------------------------------------------------
		
		 d=driver.findElement(By.xpath("//*[@class=\"widget-datepicker-hd\"]//*[@class=\"widget-datepicker-label\"]"));
		 while(!d.getText().contains("September 2020"))
		 {
			 p = (List<WebElement>) driver.findElements(By.xpath("//*[@class=\"widget-datepicker-hd\"]/button[2]"));
			 ((List<WebElement>) p).get(1).click();
		 }
		 
		 //Day Select
		 
		 List<WebElement> date =  driver.findElements(By.xpath("/html/body/div[6]/div[2]/div[1]/div[2]/table/tbody/tr/td/a"));
		  
		  count = date.size();
		 
		  for(i=0;i<count;i++)
		  {
			  text=date.get(i).getText();
		 
		  if(text.equalsIgnoreCase("10"))
		  {
			  date.get(i).click();
			  break;
		  }
		  }	  
			
		  //Scroll Up/Down
		  
		  JavascriptExecutor js = (JavascriptExecutor) driver;
	      js.executeScript("window.scrollBy(0,-600)", "");
	      
//-----------------------------------------------------DataProvider---------------------------------------------------------------------
	      
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
				i++;
			}
			
		 return data; 
		 
//------------------------------------------Assert---------------------------------------------------------------------------
		 
		  Assert.assertTrue(linksCount>150);
		  
//-----------------------------------------Explicit Wait----------------------------------------------------------------------
		  
		  WebDriverWait wai8= new WebDriverWait(driver,30);
		  wai8.until(ExpectedConditions.elementToBeClickable(By.xpath("x-path")));
		  
//-----------------------------------------
	  

		
		  
		  
		

	}

}
