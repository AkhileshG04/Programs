package Hotels;

import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class Test_Base {
	WebDriver driver;

  
  @BeforeMethod
  public void beforeMethod() {
	      System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		  driver = new ChromeDriver();
		  driver.get("https://in.hotels.com/");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
  }

  @AfterMethod
  public void afterMethod() throws IOException {
	  JavascriptExecutor js = (JavascriptExecutor) driver;
      js.executeScript("window.scrollBy(0,-600)", "");
	  
	  TakesScreenshot scrn = ((TakesScreenshot)driver);
		 File src = scrn.getScreenshotAs(OutputType.FILE);
		 String i="imgFail";
		 File dest = new File("C:\\latest\\latest\\Screenshots\\"+i+System.currentTimeMillis()+".png");
		 FileUtils.copyFile(src, dest);
//		 driver.quit();
  }

}
