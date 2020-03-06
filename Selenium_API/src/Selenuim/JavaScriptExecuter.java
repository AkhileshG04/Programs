package Selenuim;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecuter {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		driver.get("http://moneyboats.com/");
		
		driver.manage().window().maximize();
		Thread.sleep(5000L);
		
		js.executeScript("window.scrollBy(0,600)" );

		driver.get("https://www.redbus.com");
		
		String DomainName = js.executeScript("return document.domain;").toString();
		System.out.println("Domain Name of the site is ="+DomainName);
		
		String url = js.executeScript("return document.URL;").toString();
		System.out.println("URL of the site = "+url);
		
		String TitleName = js.executeScript("return document.title;").toString();
		System.out.println("Title of the Page ="+TitleName);
		
		js.executeScript("window.location='https://www.facebook.com'");
		
	}

}
