package TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class NewTest1 {
	
	WebDriver driver;
	
  @Test
  public void f() {
	  
	  System.out.println("During Test");
	  driver.findElement(By.name("q")).sendKeys("Hello World");
  }
  @BeforeTest
  public void beforeTest() {
	  
	  System.out.println("Before Test");
	  
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.google.com");
  }

  @AfterTest
  public void afterTest() {
	  
	  System.out.println("After Test");
	  driver.close();
  }

}
