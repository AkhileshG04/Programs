package Selenuim;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class PerformSel {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		String baseUrl = "http://www.facebook.com/";
		
		driver.get(baseUrl);
		
		WebElement txt = driver.findElement(By.id("email"));
		
		Actions builder = new Actions(driver);
		Action seriesofActions = builder
				.moveToElement(txt)
				.keyDown(txt,Keys.SHIFT)
				.sendKeys(txt,"hello")
				.keyUp(txt,Keys.SHIFT)
				.doubleClick(txt)
				.contextClick()
				.build();
		
		seriesofActions.perform();
		


	}

}
