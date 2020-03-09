package TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Wai8Test {
	WebDriver driver;
	String baseUrl;
	WebElement element;
	
  @Test
  public void f() {
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get(baseUrl);
  }
 @Test
 public void g()
 {
		element = driver.findElement(By.name("q"));
		element.sendKeys("Selenium WebDriver Interview Questions");
		element.sendKeys(Keys.RETURN);
 }
 @Test
 public void h()
 {
		@SuppressWarnings("unchecked")
		List<WebElement> list = (List<WebElement>) driver.findElement(By.className("sfbgx"));
	
		System.out.println(list.size());
      System.out.println(driver.findElement(By.tagName("div")).getSize());
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
	  driver = new ChromeDriver();
	  baseUrl = "https://www.google.com";
  }

  @AfterTest
  public void afterTest() {
  }

}
