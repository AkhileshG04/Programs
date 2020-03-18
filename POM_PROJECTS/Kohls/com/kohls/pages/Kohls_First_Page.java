package com.kohls.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Kohls_First_Page {
	
	WebDriver driver;
	
	public Kohls_First_Page(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By searchBar = By.id("search");
	
	public void search(String s)
	{
		driver.findElement(searchBar).sendKeys(s);
		driver.findElement(searchBar).sendKeys(Keys.ENTER);

	}
	
	

}
