package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage {
public WebDriver driver;
	
	By firstname = By.xpath("//div[@id='shipping-new-address-form']/div[1]/div/input");
	By lastname = By.xpath("//div[@id='shipping-new-address-form']/div[2]/div/input");
	By streetaddress = By.xpath("//input[@placeholder='Street Address']");
	By city= By.xpath("//input[@placeholder='City *']");
	By selectstate = By.xpath("//Select[@placeholder='State *']");
	By zipcode = By.xpath("//div[@id='shipping-new-address-form']/div[7]/div/input");
	By email = By.xpath("//input[@placeholder='Email ID']");
	By phonenumber= By.xpath("//div[@id='shipping-new-address-form']/div[9]/div/input");
	By clickOnPayment= By.xpath("//span[contains(text(),'Continue to Payment')]");

		
	public CheckoutPage(WebDriver driver) {
		this.driver=driver;
	}
		public WebElement getFirstName()
			{
				return driver.findElement(firstname);

			}
		public WebElement getLastName()
		{
			return driver.findElement(lastname);

		}
		public WebElement getStreetName()
		{
			return driver.findElement(streetaddress);

		}
		public WebElement getCity()
		{
			return driver.findElement(city);

		}
		public void getstate()
		{
			Select s = new Select(driver.findElement(selectstate));
			s.selectByVisibleText("New York");
		}
		public WebElement getzipcode()
		{
			return driver.findElement(zipcode);
	
		}
		public WebElement getEmail()
		{
			return driver.findElement(email);

		}
		public WebElement getPhoneNumber()
		{
			return driver.findElement(phonenumber);
	
		}
		public WebElement clickOnContinueToPayment()
		{
			return driver.findElement(clickOnPayment);
	
		}
		
}
