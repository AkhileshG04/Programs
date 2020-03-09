package TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class PerformSel {
	WebDriver driver;
	String baseUrl;
	WebElement txt;
  @Test
  public void f() {
	  driver.get(baseUrl);
		
		txt = driver.findElement(By.id("email"));
		
  }
  @Test
  public void g()
  {
		Actions builder = new Actions(driver);
		Action seriesofActions = builder
				.moveToElement(txt)
				.keyDown(txt,Keys.SHIFT)
				.sendKeys(txt,"hello")
				.keyUp(txt,Keys.SHIFT)
				.doubleClick(txt)
				.contextClick()
				.build();
		
		seriesofActions.perform();
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
		 baseUrl = "http://www.facebook.com/";
  }

  @AfterTest
  public void afterTest() {
  }

}
