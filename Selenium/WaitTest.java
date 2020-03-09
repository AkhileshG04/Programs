package Selenuim;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WaitTest {

	
	public static void main(String[] args) {


		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		String baseUrl = "https://www.google.com";
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get(baseUrl);
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Selenium WebDriver Interview Questions");
		element.sendKeys(Keys.RETURN);
		@SuppressWarnings("unchecked")
		List<WebElement> list = (List<WebElement>) driver.findElement(By.className("sfbgx"));
	
		System.out.println(list.size());
        System.out.println(driver.findElement(By.tagName("div")).getSize());
        
        driver.quit();

	}

}
