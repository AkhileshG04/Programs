package Selenuim;



import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test2 {

	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		
	
		
		driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("Mobile Phones",Keys.ENTER);;
		
		driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[2]/div/span[4]/div[1]/div[1]/div/span/div/div/div/div/div[2]/div[2]/div/div[1]/div/div/div[1]/h2/a/span")).click();
		
		 ArrayList<String> availableWindows = new ArrayList<String>(driver.getWindowHandles());
		 driver.switchTo().window(availableWindows.get(1));  
		
		driver.findElement(By.xpath("//*[@id=\"buy-now-button\"]")).click();
		
		driver.findElement(By.xpath("//*[@id=\"ap_email\"]")).sendKeys("9447429171",Keys.ENTER);
				
		driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();;		
		
		driver.findElement(By.xpath("//*[@id=\"ap_password\"]")).sendKeys("!@Akhilesh",Keys.ENTER);
		
		driver.findElement(By.xpath("//*[@id=\"address-book-entry-0\"]/div[2]/span/a")).click();
		
		driver.findElement(By.xpath("//*[@id=\"pp-pMJNCQ-152\"]/div/div/div/div/div[2]/div[1]/div[1]/span")).click();
		
		Thread.sleep(2000);
		
	    driver.findElement(By.xpath("//*[@id=\"pp-pMJNCQ-146\"]")).sendKeys("Oh Come On!!",Keys.ENTER);
	    
	    
		
		
		
		
			
			
	}
}