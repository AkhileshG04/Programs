package TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Sample_alert {
	WebDriver driver;
  @Test
  public void f() {
	  driver.manage().window().maximize();
		
		driver.findElement(By.xpath("/html/body/div/div[11]/div/p/button")).click();
  }
 @Test
 public void g()
 {
				
		Alert a = driver.switchTo().alert();
		
		String at = a.getText();
		
		System.out.println("Alert Text is " +at);
		
		a.accept();
 }
 @Test
 public void h()
 {
		
		driver.findElement(By.xpath("/html/body/div/div[12]/div/p[1]/button")).click();
		driver.switchTo().alert().dismiss();
		
		System.out.println("You Clicked Ok or cancel");
  }
  @BeforeTest
  public void beforeTest() {

		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("https://www.testandquiz.com/selenium/testing.html");
  }

  @AfterTest
  public void afterTest() {
  }

}
