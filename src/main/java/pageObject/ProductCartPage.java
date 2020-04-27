package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ProductCartPage {
public WebDriver driver;
	
	By productNameOnCart = By.xpath("//a[contains(text(),'Princess Diana Inspired Blue Sapphire Ring with Di')]");
	By productPriceOnCart = By.xpath("//span[@class='price-subtotal']");
	By clickOnCheckout = By.xpath("//a[@id='btn-gtm-proceedtocheckout']");


		
	public ProductCartPage(WebDriver driver) {
		this.driver=driver;
	}
		public WebElement getProductNameOnCart()
			{
				return driver.findElement(productNameOnCart);

			}
		public WebElement getProductPriceOnCart()
		{
			return driver.findElement(productPriceOnCart);

		}
		public WebElement clickONCheckout()
		{
			return driver.findElement(clickOnCheckout);

		}
}
