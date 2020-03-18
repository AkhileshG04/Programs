package com.cruise.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Second_Set {
	WebDriver driver;
	public int flag2=0;
	
	public Second_Set(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By deckDrop = By.id("deckDropdown");
	
	By suite = By.xpath("//*[@class=\"deckdeck-plan__stateroom__subtype\"]//*[@class=\"deck-plan__stateroom__subtype__name\"]");
		
	public void selectDeck()
	{
		Select s= new Select(driver.findElement(deckDrop));
		s.selectByVisibleText("Deck Eight");
	}
	public void Check()
	{
		List <WebElement> suiteNameLi = driver.findElements(suite);
		
		int listCount = suiteNameLi.size();
		
		for(int i=0;i<listCount;i++)
		{
		
		if(suiteNameLi.get(i).getText().contains("Royal Suite"))
		{
				flag2=1;
		}
		}
		
	}
	}


