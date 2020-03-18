package com.becognizant.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Becognizant_FirstPage {
	WebDriver driver;
	
	public Becognizant_FirstPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By textid = By.id("i0116");
	By nextbtn = By.id("idSIButton9");
	By about = By.id("320123");
	By purposeLix = By.xpath("//*[@class=\"workspaces__list__wrapper mCustomScrollbar _mCS_6 mCS_no_scrollbar\"]/div/div/ul/li");
	By check =By.xpath("//*[contains(text(),\" +OUR BUSINESS IS DIGITAL+ \")]");
	By ourOrg =By.id("316535");
	By txtList = By.xpath("//*[@id=\"mCSB_40_container\"]/ul/li/a");
	
	
	
public void enterdata() throws InterruptedException
{
	WebDriverWait wait = new WebDriverWait(driver,20);
	
      //Entering Data in Text Field		
     driver.findElement(textid).sendKeys("837357@cognizant.com");
     //Clicking Next Button
     driver.findElement(nextbtn).click();
     //Waiting untill next Page Loads
     wait.until(ExpectedConditions.presenceOfElementLocated(about));
// Thread.sleep(8000L);
// Thread.sleep(8000L);
// driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

	 WebElement abt = driver.findElement(about);
//     34409wait.until(ExpectedConditions.elementToBeClickable(abt));
     abt.click();
   
 
}
public void task1()
{
 List <WebElement> purposeLi = driver.findElements(purposeLix);
 WebElement purpose = purposeLi.get(0);
 purpose.click();
 try {
 List <WebElement> checkList = driver.findElements(check);	 
 Assert.assertTrue((checkList.size() !=1), "Text found!");}catch(Exception e) {}
 
}
public void task2()
{
	driver.findElement(ourOrg).click();
	  
	  List <WebElement> txt = driver.findElements(txtList);
	  int txtsize = txt.size();
	  for(int i=0;i<txtsize;i++)
	  {
		  System.out.println(""+txt.get(i).getText());
	  }
}
 
 
 
 

}
