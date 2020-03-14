package TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.Calendar;
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

public class DomesticFlight {
	WebDriver driver;
  @Test
  public void f() throws InterruptedException {
	  
	  Actions a = new Actions(driver);
	  
//	  WebDriverWait wait = new WebDriverWait(driver,20);	  
	  
	  WebElement selectCurrency =driver.findElement(By.xpath("//*[@class=\"dropdown dropdown-currency\"]"));
	  
	  selectCurrency.click();
	  
	  List <WebElement> currency = driver.findElements(By.xpath("//*[@class=\"dropdown-menu-inner\"]//*[@class=\"dropdown-item text-center\"]"));
	  
	  int currenctlen = currency.size();
	  
	  for(int i=0;i<currenctlen;i++)
	  {
		 
		  if(((currency.get(i)).getText()).contains("EUR"))
		  {
			  currency.get(i).click();
		  }
	  }
	  	  
	  Thread.sleep(3000L);
	  
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  
	  //Select Flight Tab
	  
	  WebElement flightTab =driver.findElement(By.xpath("//*[@class=\"text-center flights \"]"));
	  flightTab.click();
	  
	  	  
	  //Clicking From TextBox
	  
	  WebElement source=driver.findElement(By.xpath("//*[@id=\"s2id_location_from\"]"));
   
	  source.click();
	  
	  //Selecting From
	  
	  List <WebElement> place = driver.findElements(By.xpath("//*[@class=\"select2-drop select2-display-none select2-with-searchbox select2-drop-active\"]//*[@class=\"select2-search\"]/input"));

	  place.get(0).sendKeys("Los Angeles");

	  //Selecting From DropDown
	  List <WebElement> sourcepick = driver.findElements(By.xpath("//*[@class=\"select2-results-dept-0 select2-result select2-result-selectable\"]/div"));
	   int listsize =sourcepick.size();
	  for(int i=0;i<listsize;i++)
	  { 
		  if(((sourcepick.get(i)).getText()).contains(" (LAX)"))
		  {
			  sourcepick.get(i).click();
			  break;
		  }
	  }

	  //Clicking To	  
	    
	  WebElement toLocation =driver.findElement(By.xpath("//*[@id=\"s2id_location_to\"]"));

	  toLocation.click();
  
	  Thread.sleep(2000L);
	  
	  //Inputting Destination
	  driver.findElement(By.xpath("//*[@id=\"select2-drop\"]/div/input")).sendKeys("Dallas");

	  //Selecting From DropDown
	  List <WebElement> destpick = driver.findElements(By.xpath("//*[@class=\"select2-results\"]//*[@class=\"select2-results-dept-0 select2-result select2-result-selectable\"]/div"));
	   int lsize =destpick.size();
	  for(int i=0;i<lsize;i++)
	  { 
		  if(((destpick.get(i)).getText()).contains(" (DFW)"))
		  {
			  destpick.get(i).click();
			  break;
		  }
	  }
	  
	  driver.findElement(By.xpath("//*[@id=\"FlightsDateStart\"]")).click();
	  try {
	  Calendar now = Calendar.getInstance();
	  
	  String date =String.valueOf((now.get(Calendar.DATE))+5);
	  
	  List <WebElement> datepicker = driver.findElements(By.xpath("//*[@id=\"datepickers-container\"]/div[8]/div/div/div[2]/div"));
	  
	  int datesize=datepicker.size();
	  
	  for(int i=0;i<datesize;i++)
	  {
		  if((datepicker.get(i).getText().contains(date)))
		  {
			  datepicker.get(i).click();
		  }
	  }
	  }catch(Exception e) {}
	 
		  try
		  {
			  WebElement search =driver.findElement(By.xpath("//*[@id=\"flights\"]/div/div/form/div/div[3]/div[4]/button"));

			  Action act = a.moveToElement(search).click(search).build();
			  act.perform();
		  }catch(Exception e)
		  {
	  }
	  
	  
	  List <WebElement> s=driver.findElements(By.xpath("//*[@class=\"theme-search-results-item-price-tag\"]/strong"));
	  
	  String rate = s.get(0).getText();
	  
	  String tri=rate.substring(4);
	  
	  int rsize = Integer.valueOf((tri)) ;
	  
  
	  Assert.assertTrue(rsize>100&&rsize<250);
	   
	  

  }
  @BeforeMethod
  public void beforeMethod() {
      System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get("https://www.phptravels.net/home");
	  driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() {
//	  driver.quit();
  }

}
