package Selenuim;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Frames {

	public static void main(String[] args) {
		

		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://jqueryui.com/droppable/");
		driver.switchTo().frame(driver.findElement((By.className("demo-frame"))));
		WebElement s = driver.findElement(By.xpath(".//*[@id='draggable']"));
		WebElement t = driver.findElement(By.xpath(".//*[@id='droppable']"));
		Actions a = new Actions(driver);
		a.dragAndDrop(s, t).build().perform();
		driver.switchTo().defaultContent();
		
	}

}
