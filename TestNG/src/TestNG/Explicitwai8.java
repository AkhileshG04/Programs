package TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class Explicitwai8 {
	WebDriver driver;
  @Test
  public void f() {
	  WebDriverWait wait = new WebDriverWait(driver,20);
		
		String etitle = "Demo Guru99 Page";
		String atitle = "";
		
		driver.get("http://demo.guru99.com/test/guru99home/");
		
		driver.manage().window().maximize();
		
		atitle = driver.getTitle();
		
		
		if(atitle.contentEquals(etitle))
		{
			System.out.println("Test Passed");
			
		}
		else
		{
			System.out.println("Test Failed");
			
		}
		WebElement g;
		g = wait.until(ExpectedConditions.elementToBeClickable(By.id("philadelphia-field-submit")));
		g.click();
		System.out.println("Button CLicked");
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
