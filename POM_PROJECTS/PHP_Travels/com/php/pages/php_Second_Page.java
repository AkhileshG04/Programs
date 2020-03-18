package com.php.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class php_Second_Page {
	WebDriver driver;
	
	By searchLi = By.xpath("//*[@class=\"theme-search-results-item-price-tag\"]/strong");
	
	public php_Second_Page(WebDriver driver)
	{
		this.driver=driver;
	}
	
public void ratesSelect()
{
	List <WebElement> s=driver.findElements(searchLi);
	  
	  String rate = s.get(0).getText();
	  
	  String tri=rate.substring(4);
	  
	  int rsize = Integer.valueOf((tri)) ;
	  

	  Assert.assertTrue(rsize>100&&rsize<250);
}

}
