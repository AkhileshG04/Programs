package My_Project;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class RedBus {
	WebDriver driver;
	int i,count;
	String t;
  @Test
  public void f() throws InterruptedException {
	  
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  
		
	driver.findElement(By.id("src")).sendKeys("Chennai (All Locations)");
	driver.findElement(By.xpath("//*[@class=\"autoFill\"]//*"));
	
	driver.findElement(By.id("dest")).sendKeys("Trivandrum");
	driver.findElement(By.xpath("//*[@class=\"autoFill\"]//*[@data-id=\"71425\"]")).click();
	
	
	 WebElement w = (WebElement) driver.findElement(By.xpath("//*[@id=\"rb-calendar_onward_cal\"]/table/tbody/tr[1]/td[3]/button")); 
     
	
	WebElement txt =driver.findElement(By.xpath("//*[@id=\"rb-calendar_onward_cal\"]/table/tbody/tr[1]/td[2]"));
	  
	  while(!w.getText().contains("April 2020"))
	   {
		   Actions builder = new Actions(driver);
			Action seriesofActions = builder
					.moveToElement(txt)
					.click()
					.build();
			
			seriesofActions.perform();
	   }
	
List<WebElement> date = driver.findElements(By.xpath("//*[@class=\"wd day\" and @class=\"we day\"]"));
	
    System.out.println(date);
	
	  count=date.size();
	
	  for(i=0;i<count;i++)
	   {
		  t=(date).get(i).getText();
	
		  System.out.println(t);
	  
	    if(t.equalsIgnoreCase("20"))
	     {
		  date.get(i).click();
		  break;
	    }
	    }
	
	
		  
	
	  
  }
	  
  
  @BeforeTest
  public void beforeTest() {
	  
ChromeOptions options = new ChromeOptions();
options.addArguments("--disable-notifications");	  
System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
driver = new ChromeDriver(options);
driver.get("https://www.redbus.in/");
driver.manage().window().maximize();



  }

  @AfterTest
  public void afterTest() throws IOException {
	 TakesScreenshot scrn = ((TakesScreenshot)driver);
	 File src = scrn.getScreenshotAs(OutputType.FILE);
	 String i="imgFail";
	 File dest = new File("C:\\Users\\837357\\Desktop"+i+System.currentTimeMillis()+".png");
	 FileUtils.copyFile(src, dest);
		
	  
  }

}
