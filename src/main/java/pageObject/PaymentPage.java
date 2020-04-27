package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentPage {
public WebDriver driver;
	
	By radiobutton = By.xpath("//input[@id='braintree']");
	By nameofcard = By.xpath("//input[@placeholder='Name on Card']");
	By cardnumber = By.xpath("//input[@id='credit-card-number']");
	By selectmonth= By.cssSelector(".expirationMonth");
	By selectyear = By.cssSelector(".expirationYear");
	By cvv = By.id("cvv");
	By placeorder = By.xpath("//div[@class='orderbtn placeordertrigger payment_method_braintree']");
	By errortext = By.xpath("//div[@class='control braintree-card-control']//div[@class='hosted-error']");

		
	public PaymentPage(WebDriver driver) {
		this.driver=driver;
	}
		public WebElement clickRadioButton()
			{
				return driver.findElement(radiobutton);

			}
		public WebElement getCardName()
		{
			return driver.findElement(nameofcard);

		}
		public WebElement getCardNumber()
		
		{
			driver.switchTo().frame(driver.findElement(By.id("braintree-hosted-field-number")));
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(cardnumber));

			return driver.findElement(cardnumber);

		}
		public void getMonth()
		{
			driver.switchTo().defaultContent();


			driver.switchTo().frame(driver.findElement(By.id("braintree-hosted-field-expirationMonth")));
			Select s = new Select(driver.findElement(selectmonth));
			s.selectByVisibleText("06 - June");
		}
		public void getYear()
		{			
			driver.switchTo().defaultContent();


			driver.switchTo().frame(driver.findElement(By.id("braintree-hosted-field-expirationYear")));

			Select s = new Select(driver.findElement(selectyear));
			s.selectByVisibleText("2020");


		}
		public WebElement getCVV()
		{
			driver.switchTo().defaultContent();


			driver.switchTo().frame(driver.findElement(By.id("braintree-hosted-field-cvv")));

			return driver.findElement(cvv);

		}
		public WebElement clickPlaceOrder()
		{
			driver.switchTo().defaultContent();

			return driver.findElement(placeorder);
	
		}
		public WebElement Geterrormessage()
		{
			return driver.findElement(errortext);
	
		}
		
		
}
