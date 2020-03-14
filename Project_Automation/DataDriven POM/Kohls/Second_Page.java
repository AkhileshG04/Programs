package Kohls;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Second_Page {
	WebDriver driver;
//	WebDriverWait wait = new WebDriverWait(driver,20);
	
	public Second_Page(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By sortByLi = By.xpath("//*[@class=\"sbSelector\"]");
	
	By list = By.xpath("//*[@class=\"sbOptions\"]/li/a");
	
	By firstItem = By.xpath("//*[@class=\"products\"]/li");
	
	By sizeLi = By.xpath("//*[@class=\"size_dropDown\"]");
	
	By noItemli = By.xpath("//*[@class=\"collection_product_increase quantity-border-left ce_qtty\"]/p");
	
	By addtoCartLi =By.xpath("//*[@class=\"add-to-bag-pdp\"]//*[@class=\"collection_addToBag muted\"]");
	
	By cartCheck = By.xpath("//*[@class=\"number-items boss-number-items nonzero-items\"]");
	
	public void sort()
	{ 
		List <WebElement> sort = driver.findElements(sortByLi);
		WebElement sortBy = sort.get(0);
		sortBy.click();
		List <WebElement> c =driver.findElements(list);
		
		int len = c.size();
		
		for(int i=0;i<len;i++)
		{
			if(c.get(i).getText().contains("Price High-Low"))
					{c.get(i).click();}
		}
		
	}
	public void selectItem()
	{
//		wait.until(ExpectedConditions.elementToBeClickable(firstItem));
		List <WebElement> firstItems = driver.findElements(firstItem);
		
		firstItems.get(0).click();
		
		System.out.println("Selected Item");
	}
	public void chooseSize() throws InterruptedException
	{
		Thread.sleep(2000L);

//		wait.until(ExpectedConditions.elementToBeClickable(sizeLi));

		List <WebElement> s1= driver.findElements(sizeLi);
		WebElement size1=s1.get(0);
		Select one = new Select(size1);
		one.selectByVisibleText("42 REG");
		
		System.out.println("Chosen Size");
		
//		WebElement size2 = s1.get(1);
//		Select two = new Select(size2);
//		two.selectByVisibleText("34x34");
	}
	public void addtoCart() throws InterruptedException
	{
//		wait.until(ExpectedConditions.elementToBeClickable(noItemli));

		List <WebElement> noItemlist = driver.findElements(noItemli);
		noItemlist.get(0).click();
		
		Thread.sleep(2000L);
		
		List <WebElement> addtoc = driver.findElements(addtoCartLi);
		addtoc.get(0).click();
		
		Thread.sleep(2000L);

		
		System.out.println("Added to Cart");
		
		WebElement cart= driver.findElement(cartCheck);
		
		int n = Integer.parseInt(cart.getText());
		
		Assert.assertTrue(n==2);
		
		
	}

}
