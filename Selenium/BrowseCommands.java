package Selenuim;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowseCommands {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		String url ="https://www.google.com";
		
		driver.get(url);
		
		String title = driver.getTitle();
		
		int tlen = title.length();
		
		System.out.println("Title of the Page is : " +title);
		System.out.println("Length of the title is : "+tlen);
		
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
		
		String psource = driver.getPageSource();
		int psourcelen = psource.length();
		
		System.out.println("Total length of the page source is : "+psourcelen);
		
		driver.close();
		
	}

}
