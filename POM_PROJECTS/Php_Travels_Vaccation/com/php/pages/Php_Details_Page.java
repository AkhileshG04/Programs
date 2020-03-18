package com.php.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Php_Details_Page {
	
	WebDriver driver;
	
	public Php_Details_Page(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By nameElement = By.xpath("//*[@class=\"col-md-12 go-right form-group\"]//*[@class=\"form-control\"]");
	
	By phoneElement = By.xpath("//*[@class=\"col-md-12 go-left form-group\"]//*[@class=\"form-control\"]");
	
	By messageElement = By.xpath("//*[@class=\"col-md-12\"]//*[@class=\"form-control\"]");
	
	By contactElement = By.xpath("//*[@class=\"col-md-12\"]//*[@class=\"btn btn-success btn-success btn-block btn-lg\"]");
		
	
	public void EnterDetails(String name,String phoneNo,String message)
	{
		driver.findElement(nameElement).sendKeys(name);
		driver.findElement(phoneElement).sendKeys(phoneNo);
		driver.findElement(messageElement).sendKeys(message);
		
		driver.findElement(contactElement).click();
		
	}

}
