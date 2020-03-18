package com.hotels.test;

import org.testng.annotations.Test;
import com.hotels.datasources.Read_Excel;
import com.hotels.base.hotels_Test_Base;
import com.hotels.pages.hotels_chooseroom_page;
import com.hotels.pages.hotels_payment_page;
import com.hotels.pages.hotels_search_page;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.DataProvider;


public class Hotels_Test extends hotels_Test_Base 
{
  @Test(dataProvider = "dp")
  public void f(String city,String checkin,String inmonth,String checkout,String outmonth) throws Exception 
  {
	  
	  String title=null;
	  
	  hotels_search_page s =new hotels_search_page(driver);
	  hotels_chooseroom_page c = new hotels_chooseroom_page(driver);
	  hotels_payment_page p = new hotels_payment_page(driver);
	  
	  driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);  

	  Read_Excel.setExcelFile("C:\\latest\\latest\\Automation\\HotelsKeyword.xlsx", "HotelsKeyword");
	
		 
	  for(int r=0;r<10;r++)
	  {
		  String Actions = Read_Excel.getCellData(r,0);
		  
		  if(Actions.contains("Place"))
		  {
			  s.place(city);
		  }
		  if(Actions.contains("Check in Date"))
		  {
			  s.Checkindate(inmonth, checkin);
		  }
		  if(Actions.contains("Check out Date"))
		  {
			  s.Checkoutdate(outmonth, checkout);
		  }
		  if(Actions.contains("Submit"))
		  {
			  s.submit();
		  }
		  if(Actions.contains("Choose Room"))
		  {
			  c.chooseRoom();
		  }
		  if(Actions.contains("Book Now"))
		  {
			  c.BookNow();
		  }
		  if(Actions.contains("PopUp"))
		  {
			  c.Popup();
		  }
		  if(Actions.contains("Personal Details"))
		  {
			  p.PersonalDetails();
		  }
		  if(Actions.contains("Card Details"))
		  {
			  p.CardDetails();
		  }
		  if(Actions.contains("Book Final"))
		  {
			  p.Book();
		  }
	  }
	title = driver.getTitle();
	if(title.equalsIgnoreCase("Payment GatWay"))
	{
		System.out.println("Pass");
	}else if(title.isEmpty())
	{
		System.out.println("Fail");
	}
	else
		System.out.println("Ski");
  
  }
 
	

  @DataProvider(name ="dp")
  public Object[][] dp() throws Exception {
	
	  int i,j;
	    Object[][] data= new Object[12][5];
	    
	    Read_Excel.setExcelFile("C:\\latest\\latest\\Automation\\HotelsData.xlsx", "HotelDetails");
	    
	    for(i=0;i<12;i++)
	    {
	    	j=0;
	    	for(j=0;j<5;j++)
	    	{
	    		data[i][j]=Read_Excel.getCellData(i, j);
	    	}
	    }

			return data;
  }
}
