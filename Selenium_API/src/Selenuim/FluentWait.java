package Selenuim;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FluentWait {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		
		driver.get("https://www.irctc.co.in");
		driver.manage().window().maximize();
		
		System.out.println("Before Clicking Image");
		
		FluentWait wait = new FluentWait().withTimwout(50,TimeUnits.)

	}

}
