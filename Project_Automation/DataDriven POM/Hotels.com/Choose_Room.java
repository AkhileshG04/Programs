package Hotels;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Choose_Room {
	
	WebDriver driver;
	WebElement cho;
	
	public Choose_Room(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By ChooseRoom = By.xpath("//*[@id=\"listings\"]/ol/li/article/section/aside/a");
	
	By BookNow1 = By.xpath("//*[@id=\"book-now-button\"]");
	
	By BookNow2 = By.xpath("//*[@class=\"cta-wrap\"]/form/button");
	
	By popUpCondition = By.xpath("//*[@id=\"pay-now-etp-form\"]//*[@type=\"submit\" and @class=\"cta\"]");
	
	By cutpopUp =By.xpath("//*[@id=\"pay-now-etp-form\"]//*[@type=\"submit\" and @class=\"cta\"]");
	
	public void chooseRoom()
	{
		try {
			//Choosing Room
				List<WebElement> choose =driver.findElements(ChooseRoom);
				cho=choose.get(0);
				 cho.click();
				 
				
					 
					 
			}
			catch(Exception e)
			{
				
				
			}
	}
	public void BookNow() throws InterruptedException
	{
		driver.findElement(BookNow1).click();
		Thread.sleep(2000L);


		//Book Now Button
		List <WebElement> yuq= driver.findElements(BookNow2);
		Thread.sleep(2000L);
		try {

		WebElement op =yuq.get(0);
		op.click();
		Thread.sleep(2000L);
		}
		catch(IndexOutOfBoundsException e)
		{
			
		}
	}
	public void Popup()
	{
		try
		{
		if((driver.findElements(popUpCondition))!=null)
		{

			driver.findElement(cutpopUp).click();
		}
		}catch(Exception e)
		{}
	}

}
