package Hotels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Payment {
	
	WebDriver driver;
	
	public Payment(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By FName = By.xpath("//*[@id=\"room-details-room-0-first-name\"]");
	
	By LName = By.xpath("//*[@id=\"room-details-room-0-last-name\"]");
	
	By email = By.xpath("//*[@id=\"contact-details-email\"]");
	
	By phone = By.xpath("//*[@id=\"contact-details-phone\"]");
	
	By Ctype = By.xpath("//*[@id=\"payment-details-card-type-selector\"]");
	
	By Cno = By.xpath("//*[@id=\"payment-details-card-number\"]");
	
	By Dexpiry = By.xpath("//*[@id=\"expiry-month\"]");
	
	By Mexpiry = By.xpath("//*[@id=\"expiry-year\"]");
	
	By cvv = By.xpath("//*[@id=\"payment-details-cvv\"]");
	
	By Submit = By.xpath("//*[@id=\"book-button\"]");
	
	public void PersonalDetails()
	{
		driver.findElement(FName).sendKeys("Varun");
		
		driver.findElement(LName).sendKeys("Narayanan");
				
		driver.findElement(email).sendKeys("Varunnarayanan@gmail.com");

		driver.findElement(phone).sendKeys("852649585");
	}
	
	public void CardDetails() throws InterruptedException
	{
		Select g1 =new Select(driver.findElement(Ctype));
		g1.selectByVisibleText("Visa");


		driver.findElement(Cno).sendKeys("4500850065221995");
				
		driver.findElement(Dexpiry).sendKeys("04");

		driver.findElement(Mexpiry).sendKeys("23");

		driver.findElement(cvv).sendKeys("365"); 
		
		Thread.sleep(2000L);
	}
	public void Book()
	{
		driver.findElement(Submit).click();

	}
	

}
