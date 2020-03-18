package com.php.test;

import org.testng.annotations.Test;

import com.php.datasources.Read_Excel;
import com.php.pages.Php_Details_Page;
import com.php.pages.Php_Offers_Page;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class Php_Travels_Test {
	WebDriver driver;
  @Test(priority=0)
  public void select_summervacation() 
  {
	  
	  Php_Offers_Page offerPage = new Php_Offers_Page(driver);
	  
	  offerPage.selectCurrenct();
	  offerPage.summerVaccation();
  
  }
  @Test(dataProvider="Details",priority=1)
  public void enter_details(String name,String phoneNo,String message)
  {
	  
	  Php_Details_Page detailsPage = new Php_Details_Page(driver);
	  
	  detailsPage.EnterDetails(name, phoneNo, message);

  }
 @DataProvider(name="Details")
 public Object[][] Dataprovider() throws Exception
 { 
	 int i,j;
     Object[][] data= new Object[5][3];
  
	Read_Excel.setExcelFile("C:\\latest\\latest\\Automation\\Php_Details.xlsx", "Details");
 
     for(i=0;i<5;i++)
     {
 	   j=0;
 	   for(j=0;j<3;j++)
 	    {
 		data[i][j]=Read_Excel.getCellData(i, j);
 	    }
     }

		return data;
}


  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get(" https://phptravels.net/offers");
	  driver.manage().window().maximize();
	 
  }

  @AfterClass
  public void afterClass() {
	  JavascriptExecutor js = (JavascriptExecutor) driver;
      js.executeScript("window.scrollBy(0,300)", "");
      
	  TakesScreenshot scrn = ((TakesScreenshot)driver);
		 File src = scrn.getScreenshotAs(OutputType.FILE);
		 String i="imgFail";
		 File dest = new File("C:\\latest\\latest\\Screenshots\\"+i+System.currentTimeMillis()+".png");
		 try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  driver.quit();
  }

}
