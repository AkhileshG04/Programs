package TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Navigation {
	WebDriver driver;
	String appurl;
  @Test
  public void a() {
	 driver.navigate().to(appurl);
  }
  @Test
  public void b() {
  
		
	 driver.manage().window().fullscreen();
  }
  @Test
  public void c() {
		
	 driver.findElement(By.xpath("//*[@id=\"menu-top\"]/li[2]/a")).click();
  }
  @Test
  public void d() {
		
	driver.navigate().back();
		
	driver.navigate().forward();
		
	driver.navigate().to(appurl);
  }
  @Test
  public void e() {
		
	driver.navigate().refresh();
  }
  
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
	  driver= new ChromeDriver();
	  appurl= "http://www.DemoQA.com";
  }

  @AfterTest
  public void afterTest() {
  }

}
