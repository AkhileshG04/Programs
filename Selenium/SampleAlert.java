package Selenuim;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SampleAlert {

	public static void main(String[] args) {
		
		

		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.testandquiz.com/selenium/testing.html");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("/html/body/div/div[11]/div/p/button")).click();
				
		Alert a = driver.switchTo().alert();
		
		String at = a.getText();
		
		System.out.println("Alert Text is " +at);
		
		a.accept();
		
		driver.findElement(By.xpath("/html/body/div/div[12]/div/p[1]/button")).click();
		driver.switchTo().alert().dismiss();
		
		System.out.println("You Clicked Ok or cancel");
		driver.close();

	}

} 
