package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage {
public WebDriver driver;
	
	//Page Object for the Click on Blue Sapphire Ring
	//By blueSapphire = By.xpath("//a[text()='Blue Sapphire']");
	
	
	public LandingPage(WebDriver driver) {
		this.driver=driver;
	}
		public void clickSapphire() throws InterruptedException
	{
			Actions action = new Actions(driver);
			//Mouse Hover on Ring menu
			action.moveToElement(driver.findElement(By.xpath("//a[@class='level-0']//span[contains(text(),'Rings')]"))).build().perform();
			//Click on Blue Sapphire Ring
//			WebDriverWait wait1 = new WebDriverWait(driver, 100);
//			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@data-omniture-value='Rings | Shop By Colored Gemstone | Blue Sapphire']")));
			Thread.sleep(5000);

			action.moveToElement(driver.findElement(By.xpath("//a[text()='Blue Sapphire']"))).click().build().perform();
			//return driver.findElement(blueSapphire);

	}


}
