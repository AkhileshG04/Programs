package TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class Right_click {
	WebDriver driver ;
	WebElement e ;
  @Test
  public void f() {
	  driver.get("https://medialize.github.io/jQuery-contextMenu/demo.html");
	  e = driver.findElement(By.xpath("html/body/div/section/div/div/div/p/span"));
  }
  @Test
  public void g()
  {
		Actions act = new Actions(driver);
		act.contextClick(e).perform();
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
