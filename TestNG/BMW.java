package TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;


import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class BMW {
	WebDriver driver;
  @Test
  public void f() {
	  Actions a=new Actions(driver);
	  
//	  WebDriverWait wait = new WebDriverWait(driver,30);
	  
	  List <WebElement> model =driver.findElements(By.xpath("//*[@class=\"tw-relative tw-p-400 tw-m-0 tw-flex tw-items-center tw-font-bmw-bold tw-text-450 tw-border-b-400 tw-border-transparent tw-text-grey-500 xl:hover:tw-text-grey-900 xl:hover:tw-border-b-400 xl:hover:tw-border-primary-500 xl:hover:tw-text-grey-900\"]"));
	  model.get(0).click();
	  
	  List <WebElement> series = driver.findElements(By.xpath("//*[@class=\"tw-cursor-pointer tab-scroll-header-item tw-z-10 tab-bar-animation\"]//*[@class=\"tw-relative tw-overflow-hidden tw-pl-400 tw-pr-400 tw-m-0 tw-flex tw-items-center tw-font-bmw-bold tw-text-450 tw-text-grey-500 tw-border-b-400 tw-border-transparent hover:tw-text-grey-500 lg:hover:tw-border-b-400 lg:hover:tw-border-primary-500 lg:hover:tw-text-grey-900\"]"));
	  series.get(2).click();
	  
	  WebElement popup = driver.findElement(By.xpath("//*[@class=\"cosy-image-wrapper tw-relative\"]"));
	  Action act=a.moveToElement(popup).click().build();
	  act.perform();
	  
	  List <WebElement> tech = driver.findElements(By.xpath("//*[@class=\"tw-font-bmw-bold tw-text-450 tw-no-underline tw-m-0 focus:tw-text-grey-500 tw-text-grey-500\"]"));
	  tech.get(1).click();
	  
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  
	  List <WebElement> pewer = driver.findElements(By.xpath("//*[@class=\"show-for-medium-up\"]//*[@class=\"ds2-component ds2-tracking-aware\"]//*[@class=\"ds2-cms-output\"]"));
	  WebElement hpow=pewer.get(7);
	  String carpow = hpow.getText();
      int Cpewer=Integer.parseInt(carpow.substring(5, 8));
      Assert.assertTrue(Cpewer<500);
      System.out.println("Does not meet my requirements");
	  
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  
	  System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get("https://www.bmw.in/en");
	  driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() throws IOException {
//	 driver.quit();
  }

}
