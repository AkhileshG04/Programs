package Selenuim;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SampleJava {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com");
		
		driver.wait(2000L);
		
		
		
		
		Thread.sleep(2000L);
		String title = driver.getTitle();
		
		 System.out.println(" "+title);
		 
		 driver.switchTo().window("Google");
		 
		 driver.findElement(By.id("gb_70")).sendKeys(Keys.ENTER);
			
			driver.findElement(By.name("identifier")).sendKeys("akhileshgopu1");
			
			driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/span/span")).click();
			
			driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys("Akhilesh#1997");
			
			driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/span/span")).sendKeys(Keys.ENTER);
		 
	}

}
