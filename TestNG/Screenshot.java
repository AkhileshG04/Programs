package TestNG;

import org.testng.annotations.Test;



import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Screenshot {
	
	WebDriver driver;
	String url;
  @Test
  public void f() {
	  
	  System.out.println(driver.getTitle());
	  driver.findElement(By.xpath("//*[contains(@href,'popup.php')]")).click();
	  Set<String> windowsID =driver.getWindowHandles();
	  Iterator<String> it=windowsID.iterator();
	  String fwindow =it.next();
	  String swindow = it.next();
	  driver.switchTo().window(swindow);
	  System.out.println(driver.getTitle());
	  driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys("example@email.com");
	  driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
	  
	  
	  
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
		url ="https://www.demo.guru99.com/popup.php";
		
		driver.get(url);
		driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() throws IOException {
	  
	  TakesScreenshot scrn = ((TakesScreenshot)driver);
	  File src = scrn.getScreenshotAs(OutputType.FILE);
	  File dest = new File("C:\\latest\\latest\\Screenshots\\"+System.currentTimeMillis()+".png");
	  FileUtils.copyFile(src, dest);
	  driver.close();	  
	  
	  
  }

}
