package com.cruise.test;

import org.testng.annotations.Test;

import com.cruise.pages.First_Set;
import com.cruise.pages.Second_Set;
import org.testng.annotations.BeforeSuite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;

public class Cruise_Test {
	WebDriver driver;
  @Test
  public void f() throws InterruptedException {
	  
	  First_Set fs = new First_Set(driver);
	  
	  fs.first();
	  
	  Second_Set ss = new Second_Set(driver);
	  
	  ss.selectDeck();
	  ss.Check();
	  
	  Assert.assertTrue(fs.flag1==ss.flag2);
	  
  }
  
  @BeforeSuite
  public void BeforeSuite()
  {
      System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get("https://www.royalcaribbean.com/alaska-cruises");
	  driver.manage().window().maximize();
  	
  }
  @AfterSuite
  public void AfterSuite()
  {  
  	//driver.quit();
  }
}
