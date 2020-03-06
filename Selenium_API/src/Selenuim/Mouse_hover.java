package Selenuim;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Mouse_hover {

	public static void main(String[] args) {



		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demoqa.com/menu/");
		System.out.println("demoqa webpage Displayed");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		
		Actions a = new Actions(driver);
		
		WebElement menuoption = driver.findElement(By.xpath("//*[@id=\"ui-id-9\"]"));
		
		a.moveToElement(menuoption).perform();
		System.out.println("Done Mouse hover on 'Music' from Menu");
		
		

	}

}
