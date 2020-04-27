package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ProductDetailPage {
public WebDriver driver;
	
	//Page Object for the Click on Blue Sapphire Ring
	//By blueSapphire = By.xpath("//a[text()='Blue Sapphire']");
	By productname = By.xpath("//h1[@class='product-name']");
	By productprice = By.xpath("//div[@class='price']");
	By selectcarat = By.xpath("//span[contains(text(),'1.90 carats')]");
	By arrow = By.xpath("//div[@id='ringSize']/button[2]");
	By selectRingSize = By.xpath("//span[contains(text(),'7.5')]");
	By addToCart = By.xpath("//button[@id='product-addtocart-button']");
//	By clickringdropdown= By.cssSelector("#ringSize");
	By ringslider =By.xpath("//span[contains(text(),'Ring Size')]");
	By ringdropdown = By.xpath("//div[@data-id='ring_size']/div/span[2]");
		
	public ProductDetailPage(WebDriver driver) {
		this.driver=driver;
	}
		public WebElement getProductName()
			{
				return driver.findElement(productname);

			}
		public WebElement getProductPrice()
		{
			return driver.findElement(productprice);

		}
		
		public WebElement selectOption()
		{

			return driver.findElement(selectcarat);

		}
		public WebElement clickArrow()
		{

			return driver.findElement(arrow);

		}
		public WebElement selectRingSize()
		{
			return driver.findElement(selectRingSize);

		}
		public WebElement addToCart()
		{
			return driver.findElement(addToCart);

		}
		
//		public void getRing()
//		{
//			Select s = new Select(driver.findElement(clickringdropdown));
//			s.selectByValue("35");
//		}
		public WebElement runwhenslider()
		{
			return driver.findElement(ringslider);

		}
		public WebElement runwhendropdown()
		{
			return driver.findElement(ringdropdown);

		}
}
