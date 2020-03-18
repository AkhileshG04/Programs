package com.php.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Php_Offers_Page {
	
	WebDriver driver;
	
	public Php_Offers_Page(WebDriver driver)
	{
		this.driver=driver;
	}
	By currencyDropDown = By.xpath("//*[@class=\"dropdown dropdown-currency\"]");
	
	By checkconversion = By.xpath("//*[@class=\"dropdown dropdown-currency\"]/a");
	   
	By currencyDropList = By.xpath("//*[@class=\"dropdown-menu-inner\"]//*[@class=\"dropdown-item text-center\"]");
	
	By readmeButtonLi = By.xpath("//*[@class=\"row equal-height shrink-auto-md gap-15\"]//*[@class=\"ml-auto\"]//*[@class=\"btn btn-primary btn-sm btn-wide\"]");

 public void selectCurrenct()
	{
		WebElement selectCurrency =driver.findElement(currencyDropDown);
		  
		  selectCurrency.click();
		  
		  List <WebElement> currency = driver.findElements(currencyDropList);
		  
		  int currenctlen = currency.size();
		  
		  for(int i=0;i<currenctlen;i++)
		  {
			 
			  if(((currency.get(i)).getText()).contains("EUR"))
			  {
				  currency.get(i).click();
			  }
		  }
		  
	}
 
public void summerVaccation()
 {
	 WebDriverWait wait = new WebDriverWait(driver,20);
	 wait.until(ExpectedConditions.textToBePresentInElementLocated(checkconversion, "EUR"));
	 List <WebElement> readmeLi = driver.findElements(readmeButtonLi);
	 readmeLi.get(6).click();
 }
	
}
