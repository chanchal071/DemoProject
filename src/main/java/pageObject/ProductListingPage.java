package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ProductListingPage {
public WebDriver driver;
	
	//Click On First product after filter
	By firstProduct = By.xpath("//ul[@class='products-list']/li[1]/div/a/span[2]");
	
	
	public ProductListingPage(WebDriver driver) {
		this.driver=driver;
	}
		
		
		public WebElement clickOnFirstProduct()
		{
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.xpath("//ul[@class='products-list']/li[1]"))).perform();
			action.moveToElement(driver.findElement(By.xpath("//ul[@class='products-list']/li[1]/div/a/span[2]"))).click().perform();
			return driver.findElement(firstProduct);
		} 

}
