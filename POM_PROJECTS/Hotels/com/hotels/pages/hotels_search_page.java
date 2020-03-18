package com.hotels.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class hotels_search_page {
	
	WebElement d;
	List <WebElement> p;
	int count,i;
	String text;
	WebDriver driver;
	
	public hotels_search_page(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By destPicker = By.xpath("//*[@id=\"qf-0q-destination\"]");
	
	By pop = By.xpath("//*[@id=\"managed-overlay\"]/div/div/div[4]/div/div/div/div/a");
	
	By chooseDropdown = By.xpath("//*[@id=\"citysqm-asi0-s0\"]/td");
	
	By dropdownList = By.xpath("//*[@class=\"autosuggest-category-result\"]");
	
	By clickStartdate = By.xpath("//*[@id=\"qf-0q-localised-check-in\"]");
	
	By startMonth = By.xpath("//*[@class=\"widget-datepicker-hd\"]//*[@class=\"widget-datepicker-label\"]");
	
	By nextButtonCheckin = By.xpath("//*[@class=\"widget-datepicker-hd\"]/button[2]");
	
	By startDay = By.xpath("/html/body/div[6]/div[2]/div[1]/div[2]/table/tbody/tr/td/a");
	
	By clickEnddate = By.xpath("//*[@id=\"qf-0q-localised-check-out\"]");
	
	By endMonth = By.xpath("//*[@class=\"widget-datepicker-hd\"]//*[@class=\"widget-datepicker-label\"]");
	
	By nextButtonCheckout = By.xpath("//*[@class=\"widget-datepicker-hd\"]/button[2]");
	
	By endDay = By.xpath("/html/body/div[6]/div[2]/div[1]/div[2]/table/tbody/tr/td/a");
	
	By room = By.xpath("//*[@id=\"qf-0q-rooms\"]");
	
	By Adults = By.xpath("//*[@id=\"qf-0q-room-0-adults\"]");
	
	By children = By.xpath("//*[@id=\"qf-0q-room-0-children\"]");
	
	By Submit = By.xpath("//*[@id=\"hds-marquee\"]/div[2]/div[1]/div/form/div[4]/button");
	
	public void place(String city) throws InterruptedException
	{
	    driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);

	    driver.findElement(pop).click();

		driver.findElement(destPicker).sendKeys(city);;
		
		Thread.sleep(2000L);
	
	    int f=0,i=0;
	
	    driver.findElement(chooseDropdown).click();
	    
		List<WebElement> dropdown =driver.findElements(dropdownList);
		 while(f==1)
		 {

		 if(dropdown.get(i).getText().contains(city))
		 {
			 dropdown.get(i).click();
			 f=1;
		 }
		 i++;
		 }
	 }
	
	public void Checkindate(String inmonth,String checkin)
	{
		WebElement d;
		List <WebElement> p;
		int count,i;
		String text;
		
		driver.findElement(clickStartdate).click();
		
//		 Start Month
		 d=driver.findElement((startMonth));
		 while(!d.getText().contains(inmonth))
		 {
			 p = (List<WebElement>) driver.findElements(nextButtonCheckin);
			 ((List<WebElement>) p).get(1).click();
		 }
		 
//		Start Day 
	 
		 List<WebElement> dates =  driver.findElements(startDay);
		  
		  count = dates.size();
		  
		  System.out.println(count);

		  for(i=0;i<count;i++)
		  {
			  text=dates.get(i).getText();
		       if(text.equalsIgnoreCase(checkin))
		        {
			      dates.get(i).click();
			      break;
		        }
		  }
		
	}
	public void Checkoutdate(String outmonth,String checkout)
	{
		 driver.findElement(clickEnddate).click();
		 
//		 End Month
		 d=driver.findElement(endMonth);
		 while(!d.getText().contains(outmonth))
		 {
			 p = (List<WebElement>) driver.findElements(nextButtonCheckout);
			 ((List<WebElement>) p).get(1).click();
		 }
		 
//		End Day 
	 
		 List<WebElement> date =  driver.findElements(endDay);
		  
		  count = date.size();
		  
		  for(i=0;i<count;i++)
		   {
			  text=date.get(i).getText();
	     	  if(text.equalsIgnoreCase(checkout))
	     	  {
			   date.get(i).click();
			   break;
	     	  }
		   }	 
	}
	public void OtherDetails()
	{
		//Selecting Rooms	  
		 Select s1=new Select(driver.findElement(room));
		 s1.selectByVisibleText("1");
		 
		//Selecting Adults
		 Select s2=new Select(driver.findElement(Adults));
		 s2.selectByVisibleText("2");
		 
		 //Selecting Children
		 Select s3=new Select(driver.findElement(children));
		 s3.selectByVisibleText("0");
	}
	public void submit()
	{
		driver.findElement(Submit).click();
	}
	
	
}
	
	
	
	
	
	

