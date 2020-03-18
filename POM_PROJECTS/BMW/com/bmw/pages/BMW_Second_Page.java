package com.bmw.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class BMW_Second_Page {
	WebDriver driver;
	
	By clickW =By.xpath("//*[@class=\"ds2-dropdown ds2-dropdown--filter-active\"]");
	By carsli=By.xpath("//*[@class=\"ds2-dropdown-list ds2-dropdown-js-container ds2-mvc-tabs-list\"]/li");
	By pewerli=By.xpath("//*[@class=\"content ds2-technical-data--content ds2-mvc-tabs-content__panel ds2-mvc-tabs-content__panel--active\"]//*[@class=\"ds2-cms-output\"]");
	
	public BMW_Second_Page(WebDriver driver)
	{
		this.driver=driver;		
	}
	
	public void Second(int n) throws Exception
	{
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		  WebElement click =driver.findElement(clickW);
		  List <WebElement> cars = driver.findElements(carsli);
		      
			  click.click();
			  cars.get(n).click();
			  List <WebElement> pewer = driver.findElements(pewerli);
			  WebElement p= pewer.get(35);
			  int com = Integer.valueOf(((p.getText()).substring(5, 8)));
//			  System.out.println("N Value : "+n+"\tPower Value : "+com);
//			  ExcelWrite.setExcelValues(n, 0, (String.valueOf(com)));
			  ExcelWrite.ObjData(n+1,0, (String.valueOf(com)));
//			  Assert.assertEquals(com<500, com>500, "Does Not Meet My Requirements");
			  try {
				  if(com>500)
				  {	 ExcelWrite.ObjData(n+1, 1,"Meet My Requirements");}
				  else { ExcelWrite.ObjData(n+1, 1,"Does Not Meet My Requirements");}

					  
				  		 
			  Assert.assertTrue(com>500, "Does Not Meet My Requirements");
			  
			  }
			  catch(Exception e)
			  {
				
					 
			 
//			  return (String.valueOf(com));
	}
	}
	}
	
