package My_Project;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class MakeMyT {
	
	WebDriver driver;
	 int count,i;
	 List<WebElement> dates;
	 String text;
	 WebElement w,g;
	 
	
@BeforeTest
public void beforeTest() {
		  
System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
driver = new ChromeDriver();
driver.get("https://www.makemytrip.com");
driver.manage().window().maximize();

	  }
  @Test
  public void a() throws InterruptedException {
	  
	  
	  driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	  driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div/div[2]/div[1]/div[1]/label/span")).click();
	  driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[1]/div/div/div/input")).sendKeys("Chennai, India");
	  Thread.sleep(3000L);
      driver.findElement(By.xpath("//*[@id=\"react-autowhatever-1-section-0-item-0\"]/div/div[1]/p[1]")).click();
  
      
      
      driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[2]/label/span")).click();
	  driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/div/div/div/input")).sendKeys("Tirupati, India");
	  Thread.sleep(3000L);
      driver.findElement(By.xpath("//*[@id=\"react-autowhatever-1-section-0-item-0\"]/div/div[1]/p[1]")).click();
     
   
  }
  @Test
  public void b() throws InterruptedException, IOException
  {
	  

	  driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/label/span")).click();
	
	  w =(WebElement) driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[1]/div[1]/div")); 
	     
	  WebElement txt =driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[1]/span[2]"));
			  
	  while(!w.getText().contains("April 2020"))
	   {
		   Actions builder = new Actions(driver);
			Action seriesofActions = builder
					.moveToElement(txt)
					.click()
					.build();
			
			seriesofActions.perform();
	   }
      
      Thread.sleep(2000L);
List<WebElement> dates =  driver.findElements(By.xpath(".//*[@class='dateInnerCell']/p"));
	  
	  count = dates.size();
	  
	  System.out.println(count);

	  for(i=0;i<count;i++)
	  {
		  text=dates.get(i).getText();
	
		  System.out.println(text);
	  
	  if(text.equalsIgnoreCase("15"))
	  {
		  dates.get(i).click();
		  break;
	  }
	  }
	  
	  Thread.sleep(2000L);
	  driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/p/a")).click();//Search
	  Thread.sleep(2000L);
	 
	  Thread.sleep(3000L);
		 	 
		 
	  List<WebElement> bnow=driver.findElements(By.xpath("//*[@class=\"pull-left make_relative\"]//*[@class=\" fli_primary_btn text-uppercase \"]"));
		 Iterator<WebElement> it=bnow.iterator();
		 WebElement booknow1=it.next();
		 WebElement booknow2=it.next();
		 WebElement booknow3=it.next();
		 WebElement booknow4=it.next();
		 WebElement booknow5=it.next();
		 WebElement booknow6=it.next();
		 
		 Actions a = new Actions(driver);
		 Action serial = a
		 				 .moveToElement(booknow5)
		 				 .click()
		 				 .build();
		 		 serial.perform();  	
		  
	  ArrayList<String> availableWindows = new ArrayList<String>(driver.getWindowHandles());
	     driver.switchTo().window(availableWindows.get(1));  
	     Thread.sleep(6000L);
	     
	    if((driver.findElement(By.xpath("//*[@class=\"make_relative\"]/label[2]/input"))) != null)
	    		{
	     WebElement rb=driver.findElement(By.xpath("//*[@class=\"make_relative\"]/label[2]/input"));//radio_button
	     Thread.sleep(2000L);
	     rb.click();
	    		}
	    Thread.sleep(2000L);
	    WebElement s= driver.findElement(By.xpath("//*[@id=\"review-continue\"]"));
	    Thread.sleep(2000L);//submit
	
		 Action s1 = a
		 				 .moveToElement(s)
		 				 .click()
		 				 .build();
		 		 s1.perform();  
	     
	     WebElement add =driver.findElement(By.xpath("//*[@id=\"wrapper_ADULT\"]/a"));//Add adults
	     Thread.sleep(2000L);
	     Action s2 = a
 				 .moveToElement(add)
 				 .click()
 				 .build();
 		 s2.perform(); 
	    
	     Thread.sleep(3000L);
	   
	     WebElement fname =driver.findElement(By.xpath("//*[@class=\"tvlrFormField make_relative FIRST_NAME\"]/input"));
	     fname.click();
	     Thread.sleep(2000L);
	     fname.sendKeys("Akhilesh");//Name
	     
	     WebElement lname =driver.findElement(By.xpath("//*[@class=\"tvlrFormField make_relative LAST_NAME\"]/input"));
	     lname.click();
	     Thread.sleep(2000L);
	     lname.sendKeys("SB");//LastName
	     
	 
	     WebElement fm =driver.findElement(By.xpath("//*[@class=\"chooseGender-info GENDER \"]/label[1]"));
	     fm.click();
	     Thread.sleep(2000L);
	     
	   
	     WebElement p =driver.findElement(By.xpath("//*[@class=\"tvlrFormField make_relative MOBILE_NUMBER\"]/input"));
	     p.click();
	     Thread.sleep(2000L);
	     p.sendKeys("9447426546");
	    
	 
	     
	     WebElement email =driver.findElement(By.xpath("//*[@class=\"tvlrFormField make_relative EMAIL\"]/input"));
	     email.click();
	     Thread.sleep(2000L);
	     email.sendKeys("examplemail@gmail.com");
	     
	     
	     WebElement su2 =driver.findElement(By.xpath("//*[@class=\"ack-cta btn fli_primary_btn text-uppercase\"]"));
	     Action s3 = a
 				 .moveToElement(su2)
 				 .click()
 				 .build();
 		 s3.perform(); 
	     
 		 
 		
 		WebElement su3 =driver.findElement(By.xpath("//*[@id=\"ancillary-secondary\"]"));
	     Action s4 = a
				 .moveToElement(su3)
				 .click()
				 .build();
		 s4.perform();
	    
		 Thread.sleep(5000L);
		 
		
		 WebElement su4 =driver.findElement(By.xpath("//*[@id=\"CC\"]/span[2]"));
	     Action s5 = a
				 .moveToElement(su4)
				 .click()
				 .build();
		 s5.perform();
	  
		
		 WebElement cardno =driver.findElement(By.xpath(" //*[@class=\"clearfix card_type_input\"]//*[@name=\"PAYMENT_cardNumber\"] "));
	     cardno.click();
	     Thread.sleep(2000L);
	     cardno.sendKeys("5228791099000012");
	     

		 WebElement cname =driver.findElement(By.xpath("//*[@id=\"PAYMENT_nameOnCard\"]"));
	     cname.click();
	     Thread.sleep(2000L);
	     cname.sendKeys("Akhilesh S B");
	     
	     
	     Select month =  new Select(driver.findElement(By.xpath("//*[@id=\"PAYMENT_expiryMonth\"]")));
		 month.selectByVisibleText("03");
	    		 
	    
	    Select year =  new Select(driver.findElement(By.xpath("//*[@id=\"PAYMENT_expiryYear\"]")));
	     year.selectByVisibleText("2025");
	    	    	 
	     WebElement cvv =driver.findElement(By.xpath(" //*[@id=\"PAYMENT_cvv\"]"));
	    	 cvv.click();
	    	 Thread.sleep(2000L);
	    	 cvv.sendKeys("852");
	    	 
	    	
		  
		    	    	 
		 		    
		   Select country =  new Select(driver.findElement(By.xpath("//*[@id='PAYMENT_billingCountry']")));
		    country.selectByVisibleText("India");
		    		    	   
		    		    	   
		    		    	   
		   WebElement addr =driver.findElement(By.xpath(" //*[@id=\"PAYMENT_billingAddress\"]	    "));
		    addr.click();
		    	Thread.sleep(2000L);
		    	addr.sendKeys("Akhilesh S B ");
		    	addr.sendKeys(Keys.ENTER);
		    	addr.sendKeys("Door no ");
		    	addr.sendKeys(Keys.ENTER);
		    	addr.sendKeys("Street ");
		    	addr.sendKeys(Keys.ENTER);
		    	addr.sendKeys("City");
		    	
		    			
		    	driver.findElement(By.xpath("//*[@id=\"PAYMENT_billingCity\"]")).sendKeys("Trivandrum");
		    			
		    	driver.findElement(By.xpath("//*[@id=\"PAYMENT_billingPin\"]")).sendKeys("695582");
		    			
		    	driver.findElement(By.xpath("//*[@id=\"PAYMENT_billingState\"]")).sendKeys("Kerala");
		    		    	   
		    	 WebElement su7 =driver.findElement(By.xpath("//*[@id=\"widgetPayBtn\"]//*[@class=\"pull-left lock_txt lato-bold\"]"));
				   Action s8 = a
				   .moveToElement(su7)
				    .click()
				    .build();
				    s8.perform();
				    	    	 
		    	    	 
		    	
	     		
  }
  

 
@AfterTest
  public void afterTest() throws IOException {
	
	TakesScreenshot scrn = ((TakesScreenshot)driver);
	 File src = scrn.getScreenshotAs(OutputType.FILE);
	 String i="imgFail";
	 File dest = new File("C:\\Users\\t-mahavignesh\\Desktop"+i+System.currentTimeMillis()+".png");
	 FileUtils.copyFile(src, dest);
	
  }

}
