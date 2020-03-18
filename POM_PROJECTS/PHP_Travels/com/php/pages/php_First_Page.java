package com.php.pages;

import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class php_First_Page {
	WebDriver driver;
	
   public php_First_Page(WebDriver driver)
   {
	   this.driver=driver;
   }

   By dropDown = By.xpath("//*[@class=\"dropdown dropdown-currency\"]");
   
   By dropList = By.xpath("//*[@class=\"dropdown-menu-inner\"]//*[@class=\"dropdown-item text-center\"]");
   
   By flightTabLi = By.xpath("//*[@class=\"text-center flights \"]");
   
   By fromTextBox = By.xpath("//*[@id=\"s2id_location_from\"]");
   
   By placeLi = By.xpath("//*[@class=\"select2-drop select2-display-none select2-with-searchbox select2-drop-active\"]//*[@class=\"select2-search\"]/input");

   By sourcePickLi = By.xpath("//*[@class=\"select2-results-dept-0 select2-result select2-result-selectable\"]/div");
   
   By destpickLi = By.xpath("//*[@id=\"s2id_location_to\"]");
   
   By destinationpick = By.xpath("//*[@id=\"select2-drop\"]/div/input");
   
   By destinationpickLi = By.xpath("//*[@class=\"select2-results\"]//*[@class=\"select2-results-dept-0 select2-result select2-result-selectable\"]/div");
   
   By flightDay = By.xpath("//*[@id=\"FlightsDateStart\"]");
   
   By datePickerLi = By.xpath("//*[@id=\"datepickers-container\"]/div[8]/div/div/div[2]/div");
   
   By searchLi = By.xpath("//*[@id=\"flights\"]/div/div/form/div/div[3]/div[4]/button");
   
	public void selectCurrenct()
	{
		WebElement selectCurrency =driver.findElement(dropDown);
		  
		  selectCurrency.click();
		  
		  List <WebElement> currency = driver.findElements(dropList);
		  
		  int currenctlen = currency.size();
		  
		  for(int i=0;i<currenctlen;i++)
		  {
			 
			  if(((currency.get(i)).getText()).contains("EUR"))
			  {
				  currency.get(i).click();
			  }
		  }
	}
	public void selectFrom() throws InterruptedException
	{
		Thread.sleep(2000L);
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		  
		  //Select Flight Tab
		  
		  WebElement flightTab =driver.findElement(flightTabLi);
		  flightTab.click();
		  
		  	  
		  //Clicking From TextBox
		  
		  WebElement source=driver.findElement(fromTextBox);
	   
		  source.click();
		  
		  //Selecting From
		  
		  List <WebElement> place = driver.findElements(placeLi);

		  place.get(0).sendKeys("Los Angeles");

		  //Selecting From DropDown
		  List <WebElement> sourcepick = driver.findElements(sourcePickLi);
		   int listsize =sourcepick.size();
		  for(int i=0;i<listsize;i++)
		  { 
			  if(((sourcepick.get(i)).getText()).contains(" (LAX)"))
			  {
				  sourcepick.get(i).click();
				  break;
			  }
		  }
	}
	public void selectTo()
	{
		 WebElement toLocation =driver.findElement(destpickLi);

		  toLocation.click();
	  		  
		  //Inputting Destination
		  driver.findElement(destinationpick).sendKeys("Dallas");

		  //Selecting From DropDown
		  List <WebElement> destpick = driver.findElements(destinationpickLi);
		   int lsize =destpick.size();
		  for(int i=0;i<lsize;i++)
		  { 
			  if(((destpick.get(i)).getText()).contains(" (DFW)"))
			  {
				  destpick.get(i).click();
				  break;
			  }
		  }
	}
	public void datePick()
	{
		 driver.findElement(flightDay).click();
		  try {
		  Calendar now = Calendar.getInstance();
		  
		  String date =String.valueOf((now.get(Calendar.DATE))+5);
		  
		  List <WebElement> datepicker = driver.findElements(datePickerLi);
		  
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
				  WebElement search =driver.findElement(searchLi);
				  Actions a = new Actions(driver);
				  Action act = a.moveToElement(search).click(search).build();
				  act.perform();
			  }catch(Exception e)
			  {
		  }
	}
}

