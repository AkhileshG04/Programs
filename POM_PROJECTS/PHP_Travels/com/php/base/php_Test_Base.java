package com.php.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class php_Test_Base {
	public WebDriver driver;
@BeforeTest
public void beforeTest() {
	
	  System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
      driver = new ChromeDriver();
	  driver.get("https://www.phptravels.net/home");
	  driver.manage().window().maximize();
}

@AfterTest
public void afterTest() 
{
	driver.quit();
 }

}


