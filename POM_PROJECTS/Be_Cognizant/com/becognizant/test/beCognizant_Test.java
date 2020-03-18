package com.becognizant.test;

import org.testng.annotations.Test;

import com.becognizant.pages.Becognizant_FirstPage;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class beCognizant_Test {
	WebDriver driver;
  @Test
  public void a() throws InterruptedException {
	  
	  Becognizant_FirstPage fs = new Becognizant_FirstPage(driver);
	  fs.enterdata();
	  Thread.sleep(8000L);
	  fs.task1();
	  fs.task2();
	  
  }
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get("https://be.cognizant.com/");
	  driver.manage().window().maximize();
  }

  @AfterClass
  public void afterClass() {
  }

}
