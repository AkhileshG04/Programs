package TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class Mouse_hover {
	WebDriver driver ;
  @Test
  public void f() {
	  driver.manage().window().maximize();
		
	driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
  }
  @Test
  public void g()
  {
		
	Actions a = new Actions(driver);
	
	WebElement menuoption = driver.findElement(By.xpath("//*[@id=\"ui-id-9\"]"));
		
	a.moveToElement(menuoption).perform();
  }
  @BeforeTest
  public void beforeTest() {

	System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
	driver= new ChromeDriver();
		
	driver.get("https://demoqa.com/menu/");
	System.out.println("demoqa webpage Displayed");
  }

  @AfterTest
  public void afterTest() {
  }

}
