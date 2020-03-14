package TestNG;

import org.testng.annotations.Test;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

public class Asserting {
	WebDriver driver;
  @Test
  public void f() throws InterruptedException {
	int a=0,b=0,c=0;
//	  Thread.sleep(10000L);
	try
	{
	 List <WebElement> linksize = driver.findElements(By.tagName("a"));

	  int linksCount = linksize.size();
      System.out.println("Total number of links on home page :" + linksCount);
      String[] links = new String[linksCount+1];
    	  Assert.assertTrue(linksCount>150);
    	     	  
      for(int i=0;i<linksCount;i++) 
      {
    	  System.out.println(""+links[i]);
          links[i]=linksize.get(i).getAttribute("href");
          
          if(links[i].equals("https://www.facebook.com/"))
          {
        	  
        	  a=1;
          }
          if(links[i].equals("https://aboutme.google.com/u/0/?referer=gplus"))
          {
        	  
        	  b=1;
          }
          if(links[i].equals("https://twitter.com/login"))
          {
        	  
        	  c=1;
          }     
      }
	}catch(Exception e) {}
    	   Assert.assertTrue(((a==1)&&(b==1)&&(c==1)));
     }
 @BeforeMethod
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	  driver.get("https://phptravels.com/demo");
	  driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterTest() {
//	  driver.quit();
  }

}
