package TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class Dropdown {
	WebDriver driver;
  @Test
  public void f() throws InterruptedException {
	  driver.manage().window().maximize();
		driver.get("https://www.testandquiz.com/selenium/testing.html");
		Select s =  new Select(driver.findElement(By.id("testingDropdown")));
		s.selectByVisibleText("Manual Testing");
		Thread.sleep(2000L);
		s.selectByIndex(3);
		
		s.deselectByIndex(2);
  }
  @BeforeTest
  public void beforeTest() {

		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
