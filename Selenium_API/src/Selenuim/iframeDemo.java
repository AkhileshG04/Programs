package Selenuim;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class iframeDemo {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		
		driver.get("http://demo.guru99.com/test/guru99home/");
		driver.manage().window().maximize();
		
		int totalFrames = driver.findElements(By.tagName("iframe")).size();
		System.out.println("Total No of Frames :"+totalFrames);
		
		driver.switchTo().frame("a0077aa5e");
		driver.findElement(By.xpath("/html/body/a/img")).click();
		Thread.sleep(2000L);
	}

}
