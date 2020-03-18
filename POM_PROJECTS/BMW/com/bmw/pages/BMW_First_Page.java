package com.bmw.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class BMW_First_Page {
	WebDriver driver;
	
	public BMW_First_Page(WebDriver driver)
	{
		this.driver=driver;
	}

	
	By modelLi = By.xpath("//*[@class=\"tw-relative tw-p-400 tw-m-0 tw-flex tw-items-center tw-font-bmw-bold tw-text-450 tw-border-b-400 tw-border-transparent tw-text-grey-500 xl:hover:tw-text-grey-900 xl:hover:tw-border-b-400 xl:hover:tw-border-primary-500 xl:hover:tw-text-grey-900\"]");
	
	By seriesLi=By.xpath("//*[@class=\"tw-cursor-pointer tab-scroll-header-item tw-z-10 tab-bar-animation\"]//*[@class=\"tw-relative tw-overflow-hidden tw-pl-400 tw-pr-400 tw-m-0 tw-flex tw-items-center tw-font-bmw-bold tw-text-450 tw-text-grey-500 tw-border-b-400 tw-border-transparent hover:tw-text-grey-500 lg:hover:tw-border-b-400 lg:hover:tw-border-primary-500 lg:hover:tw-text-grey-900\"]");
	
	By popupW =By.xpath("//*[@class=\"cosy-image-wrapper tw-relative\"]");
	
	By techLi = By.xpath("//*[@class=\"slider-nav-item tw-inline-flex tw-px-450 tw-pt-100 tw-border-b-400 tw-h-full tw-items-center hover:tw-border-primary-500 tw-border-white active\"]/a");
	
	public void First()
	{
	
		Actions a=new Actions(driver);
	
		 List <WebElement> model =driver.findElements(modelLi);
		  model.get(0).click();
		  
		  List <WebElement> series = driver.findElements(seriesLi);
		  series.get(2).click();
		  
		  WebElement popup = driver.findElement(popupW);
		  Action act=a.moveToElement(popup).click().build();
		  act.perform();
		  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		  List <WebElement> tech = driver.findElements(techLi);
		  tech.get(1).click();
	}
}
