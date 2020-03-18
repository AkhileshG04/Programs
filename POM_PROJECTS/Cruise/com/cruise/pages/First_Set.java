package com.cruise.pages;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class First_Set {
	
	WebDriver driver;
	public int flag1=0;
	
	public First_Set(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By ShipSelect = By.id("rciHeaderMenuItem-2");
	
	By ShipsList = By.xpath("//*[@class=\"gallery__thumb__glass\"]");
	//21
	
	By DeckPlansList = By.xpath("//*[@class=\"text_label centercenter\"]//*[@class=\"font-block text-white size-25rem tablet-2rem mobile-25rem\"]"); 
    //2
	
	public void first() throws InterruptedException
	{ 
		Actions a= new Actions(driver);
//		WebDriverWait wai8 = new WebDriverWait(driver,20);
		
		String text = "whale watching";
		List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'" + text + "')]"));
		if(list.size()>0)
		{
			flag1=1;
		}
		
		driver.findElement(ShipSelect).click();
		
		List <WebElement> ShipList = driver.findElements(ShipsList);
		ShipList.get(21).click();
		
		Thread.sleep(6000L);
		List <WebElement> DeckPlanList = driver.findElements(DeckPlansList);
		WebElement DeckPlan = DeckPlanList.get(3);
//		wai8.until(ExpectedConditions.elementToBeClickable(DeckPlanList));
		Action act = a.moveToElement(DeckPlan).click().build();
		act.perform();
//		DeckPlanList.get(2).click();
		
		
	}
}
