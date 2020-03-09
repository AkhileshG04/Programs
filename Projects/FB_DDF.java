package My_Project;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class FB_DDF {
	WebDriver driver;
  @Test(dataProvider = "dp")
  public void f(String uname, String pword) {
	  
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	
		 driver.findElement(By.id("email")).sendKeys(uname);
	
		 driver.findElement(By.id("pass")).sendKeys(pword);
		 
		 driver.findElement(By.id("u_0_b")).click();
		
		
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  
		  System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		  driver = new ChromeDriver();
		  driver.get("https://www.facebook.com/");
		  driver.manage().window().maximize();
  }


  @AfterMethod
  public void afterMethod() throws IOException {
	  TakesScreenshot scrn = ((TakesScreenshot)driver);
		 File src = scrn.getScreenshotAs(OutputType.FILE);
		 String i="FB_Login";
		 File dest = new File("C:\\latest\\latest\\Screenshots\\"+i+System.currentTimeMillis()+".png");
		 FileUtils.copyFile(src, dest);
		 driver.quit();
  }


  @DataProvider(name="dp")
  public Object[][] dp() throws IOException {
	  Object[][] data = new Object[3][2];

	  String s;
	  
	 int i=0,j=0;
	  
	  File file=new File("C:\\latest\\latest\\Automation\\FbLogin.xlsx");
		FileInputStream fis=new FileInputStream(file);

		@SuppressWarnings("resource")
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
					data[i][j]=s;
				
				
				
				j++;
			}
//			System.out.println(" "+i+" "+j);
//System.out.println(" "+j);
			System.out.println("");
			i++;
		}
	  
			  
		
		
	 return data; 
  }  
	 
  
  @BeforeTest
  public void beforeTest()
  {
	  System.out.println("Test Starts");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("Test Ends");
  }

}
