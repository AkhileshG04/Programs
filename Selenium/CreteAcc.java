package Selenuim;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class CreteAcc {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com/intl/en-GB/gmail/about/#");
		
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[4]/ul[1]/li[3]/a")).click();

	     ArrayList<String> availableWindows = new ArrayList<String>(driver.getWindowHandles());
	     driver.switchTo().window(availableWindows.get(1));  
	     
	     System.out.println(" "+availableWindows.get(1));
			 
		driver.findElement(By.xpath("//input[@id=\"firstname\"]")).sendKeys("Akhilesh");
		driver.findElement(By.xpath("//*[@id=\"lastName\"]")).sendKeys("SB");
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("Akhilesh67");
		driver.findElement(By.xpath("//*[@id=\"passwd\"]/div[1]/div/div[1]/input")).sendKeys("1#Akhilesh");
		driver.findElement(By.xpath("//*[@id=\"confirm-passwd\"]/div[1]/div/div[1]/input")).sendKeys("1#Akhilesh");
		
		driver.findElement(By.xpath("//*[@id=\"accountDetailsNext\"]/span/span")).click();
			

	}

}
