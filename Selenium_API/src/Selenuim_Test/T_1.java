package Selenuim_Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T_1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.irctc.co.in/nget/train-search");
				
		driver.findElement(By.xpath("//*[@id=\"origin\"]/span/input")).sendKeys("MAS");
		
		driver.findElement(By.xpath("//*[@id=\"origin and @class=\"ng-star-inserted\"]")).click();
		
        driver.findElement(By.xpath("//*[@id=\"destination\"]/span/input")).sendKeys("TVC");
        
		driver.findElement(By.className("class=\"ng-star-inserted\"")).click();
		

	}

}
