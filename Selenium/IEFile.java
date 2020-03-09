package Selenuim;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class IEFile {

	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.ie.driver", "C:\\Selenium\\IEDriverServer_x64_3.14.0\\IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver();
		
		driver.get("https://www.google.com");
		
		driver.findElement(By.id("gb_70")).sendKeys(Keys.ENTER);
		
		
		
		driver.quit();
		
		
	}

}
