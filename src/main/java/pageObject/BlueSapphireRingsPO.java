package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BlueSapphireRingsPO {
public WebDriver driver;
	
	//Page Object for the Click on Blue Sapphire Ring
	By gemStone = By.cssSelector(".filter-item.p_filterable_stone_shapes.filterable_stone_shapes");
	By selectoval = By.xpath("//li[@class='filter-item child _oval right']//span//span[contains(text(),'Oval')]");

	
	public BlueSapphireRingsPO(WebDriver driver) {
		this.driver=driver;
	}
		public WebElement clickOnGemstoneFilter()
		{
			return driver.findElement(gemStone);
		}
	
		public WebElement clickOnOval()
		{
			return driver.findElement(selectoval);
		}
		
		

}
