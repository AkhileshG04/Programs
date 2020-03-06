package Selenuim;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TEST1 {

	WebDriver driver;
	
	 public void setup() throws Exception {

			System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get("http://only-testing-blog.blogspot.in/2014/09/selectable.html");
	 }
	 
	 
	 public void Save_Image() throws IOException, InterruptedException, AWTException {
	  //Locate Image
	  WebElement Image =driver.findElement(By.xpath("//img[@border='0']"));
	
	  Actions action= new Actions(driver);
	  action.contextClick(Image).build().perform();
	  
	  
	  action.sendKeys(Keys.CONTROL, "v").build().perform();

	  Thread.sleep(3000);
	  Robot robot = new Robot();
	  // To press D key.
	  robot.keyPress(KeyEvent.VK_D);
	  // To press : key.
	  robot.keyPress(KeyEvent.VK_SHIFT);
	  robot.keyPress(KeyEvent.VK_SEMICOLON);
	  robot.keyRelease(KeyEvent.VK_SHIFT);
	  // To press \ key.
	  robot.keyPress(KeyEvent.VK_BACK_SLASH);
	  // To press "test" key one by one.
	  robot.keyPress(KeyEvent.VK_T);
	  robot.keyPress(KeyEvent.VK_E);
	  robot.keyPress(KeyEvent.VK_S);
	  robot.keyPress(KeyEvent.VK_T);
	  // To press Save button.
	  robot.keyPress(KeyEvent.VK_ENTER);  
	 }
	}