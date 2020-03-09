package TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Date_Picker {
	WebDriver driver;
	String url;
	 String text;
	 int i;
	 WebElement month;
	 int count;
	 List<WebElement> dates;
	
  @Test
  public void a() {
	  
	  driver.findElement(By.xpath("//*[@id='travel_date']")).click();
	  
	  WebElement month = driver.findElement(By.xpath("//*[@class='datepicker-days']/table/thead/tr//*[@class='datepicker-switch']"));
			  
	   while(!month.getText().contains("May"))
	   {
		   driver.findElement(By.xpath("//*[@class='datepicker-days']/table/thead/tr//*[@class='next']")).click();
	   }
  }
  @Test
  public void b()
  {
	
	  List<WebElement> dates = (List<WebElement>) driver.findElements(By.xpath("//*[@class='day']"));
	  
	  count = dates.size();
	  
	  System.out.println(count);
	  
	  for(i=0;i<count;i++)
	  {
		  text=dates.get(i).getText();
		  System.out.println(text);
	  
	  if(text.equalsIgnoreCase("22"))
	  {
		  dates.get(i).click();
		  break;
	  }
	  }
	  
  }	
	  
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
		url ="https://www.path2usa.com/travel-companions";
		
		driver.get(url);
  }

  @AfterTest
  public void afterTest() {
  }

}
