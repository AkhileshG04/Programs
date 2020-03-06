package Selenuim;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigation {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		

		String appurl = "http://www.DemoQA.com";
		driver.navigate().to(appurl);
		
		driver.manage().window().fullscreen();
		
		driver.findElement(By.xpath("//*[@id=\"menu-top\"]/li[2]/a")).click();
		
		driver.navigate().back();
		
		driver.navigate().forward();
		
		driver.navigate().to(appurl);
		
		driver.navigate().refresh();
		
		driver.close();
		
	}

}
