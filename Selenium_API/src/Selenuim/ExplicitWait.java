package Selenuim;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		
		driver.get("https://www.irctc.co.in");
		driver.manage().window().maximize();
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		System.out.println("Before Clicking Image");
		wait.until(ExpectedConditions.visibilityOf((WebElement) By.xpath("//*[@id=\"divMain\"]/div/app-main-page/div[1]/div/div[1]/div/div/div[2]/div")));
		System.out.println("After Clicking Image");
		driver.close();
	}

}
