package TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class Frames {
	WebDriver driver;
	WebElement s;
	WebElement t;
  @Test
  public void a() {
	  driver.get("http://jqueryui.com/droppable/");
		driver.switchTo().frame(driver.findElement((By.className("demo-frame"))));
		s = driver.findElement(By.xpath(".//*[@id='draggable']"));
		t = driver.findElement(By.xpath(".//*[@id='droppable']"));
  }
  @Test
  public void b()
  {
		Actions a = new Actions(driver);
		a.dragAndDrop(s, t).build().perform();
  }
  @BeforeTest
  public void beforeTest() {
	  

	System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
	driver = new ChromeDriver();
		
  }

  @AfterTest
  public void afterTest() {
  }

}
