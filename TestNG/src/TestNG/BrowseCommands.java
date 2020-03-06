package TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class BrowseCommands {
	
	WebDriver driver;
	String url;
	
  @Test
  public void a() {
		String title = driver.getTitle();
		
		int tlen = title.length();
		
		System.out.println("Title of the Page is : " +title);
		System.out.println("Length of the title is : "+tlen);
  }
  @Test
  public void b()
  {
		String acturl = driver.getCurrentUrl();
		
		if(acturl.equals(url))
		{
			System.out.println("Verification Successful - The Correct url is opened.");
		}
		else 
		{
			System.out.println("Verification Failes - An Incorrect url is opened.");
			
			System.out.println("Actual Url is : "+acturl);
			System.out.println("Expected Url is : "+url);
		}
  }
@Test
public void c()
{
		
		String psource = driver.getPageSource();
		int psourcelen = psource.length();
		
		System.out.println("Total length of the page source is : "+psourcelen);
  }
  @BeforeTest
  public void beforeTest() {
	  
	  System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
		url ="https://www.google.com";
		
		driver.get(url);
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
