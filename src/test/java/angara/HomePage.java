package angara;


import java.io.IOException;
import java.util.Iterator;
import java.util.Set;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import pageObject.BlueSapphireRingsPO;
import pageObject.CheckoutPage;
import pageObject.LandingPage;
import pageObject.PaymentPage;
import pageObject.ProductCartPage;
import pageObject.ProductDetailPage;
import pageObject.ProductListingPage;
import resources.base;


public class HomePage extends base {
	
	private  static final Logger log = LogManager.getLogger(base.class.getName());
	//Go to home page (https://www.angara.com).
	@Test
	public void initializeBrowser() throws IOException, InterruptedException
	{
		log.info("Driver Initialized");
		
		driver = initializeDriver(); 
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		//After 5-7 seconds you will see the welcome pop-up. It sometimes is not showing even after 100 sec
		WebDriverWait wait = new WebDriverWait(driver, 300);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='visitor_popup_script_selection']")));
		//Close that Welcome popup
		driver.findElement(By.xpath("//span[@class='popup_close']")).click();		
	}
	//Hover on Rings top nav and select Sapphire rings. I didn't found Sapphire on Rings menu so i click on Blue Sapphire
	@Test (dependsOnMethods="initializeBrowser")
	public void clickOnBlueSapphire() throws InterruptedException
	{
		LandingPage lp = new LandingPage(driver);
		lp.clickSapphire();
		
	}
	//Verify page title. 
	@Test (dependsOnMethods="clickOnBlueSapphire")
	public void getTitleName()
	{
		String Expectedtitle = driver.getTitle();
		//String actualTitle = "Blue Sapphire Rings: Buy Natural Blue Sapphire Ring at Angara";
		//String actualTitle=prop.getProperty("pageTitle");
		String actualPageTitle = prop.getProperty("pageTitle");
		if(Expectedtitle.equalsIgnoreCase(actualPageTitle))
			{
			log.info("Title Matched");
			}
		else
			{
			log.error("Title Not Matched");				
			}
	}
	//Open gemstone filter and select Blue sapphire filter. I didn't found Gemstone filter so i click on Gemstone Shape and select Heart filter
	@Test (dependsOnMethods="clickOnBlueSapphire")
	public void clickFilterDropdown() throws InterruptedException
	{	
		Thread.sleep(10000);

		BlueSapphireRingsPO bsr = new BlueSapphireRingsPO(driver);
		bsr.clickOnGemstoneFilter().click();
		BlueSapphireRingsPO bsr1 = new BlueSapphireRingsPO(driver);
		bsr1.clickOnOval().click();
		//bsr.clickOnGemstoneFilter().click();

	}
	// Open 1st product.
	@Test (dependsOnMethods="clickFilterDropdown")
	public void clickOnproduct() throws InterruptedException
	{
		Thread.sleep(10000);
		ProductListingPage plp = new ProductListingPage(driver);
		plp.clickOnFirstProduct();
	}
	//redirect to child window and verify product name and product price
	@Test (dependsOnMethods="clickOnproduct")
	public void ProductName()
	{
		String parentId = driver.getWindowHandle();
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> it = ids.iterator();
		while(it.hasNext())
		{
			String childId = it.next();
			driver.switchTo().window(childId);
		}
		ProductDetailPage pd = new ProductDetailPage(driver);
		String expectedProductName = pd.getProductName().getText();
		String actualProductName = prop.getProperty("productname");
		if(expectedProductName.equalsIgnoreCase(actualProductName))
		{
			log.info("Product Name Matched");			
		}
	else
		{
		System.out.println("Product Name Not Matched");				
		}
		String expectedProductPrice = pd.getProductPrice().getText();
		String actualProductPrice = prop.getProperty("productprice");
		if(expectedProductPrice.equalsIgnoreCase(actualProductPrice))
		{
			log.info("Product Price Matched");				
		}
	else
		{
		log.error("Product Price Not Matched");				
		}
	}
	// Select Carat=3rd Number option.. 
	@Test (dependsOnMethods="ProductName")
	public void verifySelectedOption() throws InterruptedException
	{
		ProductDetailPage pd = new ProductDetailPage(driver);
		pd.selectOption().click();
		Thread.sleep(10000);
		String expectedModifiedProductPrice = pd.getProductPrice().getText();
		String actualModifiedproductPrice = prop.getProperty("modifiedproductprice");
		if(expectedModifiedProductPrice.equalsIgnoreCase(actualModifiedproductPrice))
				{
			log.info("Modified price is Matching");				
				}
		else
				{
			log.error("Modified price is Not Matching");				
				}
		//Select Ring size 7.5

		
			WebDriverWait wait = new WebDriverWait(driver, 200);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='ringSize']/button[2]")));
			pd.clickArrow().click();
			pd.selectRingSize().click();
			pd.addToCart().click();
		
	}
	//Verify Product price at cart shown same as product or not.(Subtotal price should be same as Product price)
	@Test (dependsOnMethods="verifySelectedOption")
	public void VerifyProductNameandPriceOnCart()
	{
		WebDriverWait wait = new WebDriverWait(driver, 200);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Princess Diana Inspired Blue Sapphire Ring with Di')]")));

		ProductCartPage pcp = new ProductCartPage(driver);
		String expectedproductNameOnCart = pcp.getProductNameOnCart().getText();
		if(expectedproductNameOnCart.equals(prop.getProperty("productname")))
		{
			log.info("Product in cart same as product detail");
		}
		else
		{
			log.error("Product in cart is not same as product detail");

		}
		String expectedproductPriceOnCart = pcp.getProductPriceOnCart().getText();
		if(expectedproductPriceOnCart.equals(prop.getProperty("modifiedproductprice")))
		{
			log.info("Product Price in cart same as modified product price");

		}
		else
		{
			log.error("Product Price in cart is not  same as modified product price");
			
		}
		//Click on Proceed to checkout button.
		pcp.clickONCheckout().click();
	}
	//Verify user redirect to checkout page or not.
	@Test (dependsOnMethods="VerifyProductNameandPriceOnCart")
	public void verifyCheckoutPage() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 400);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='shipping-new-address-form']/div[1]/label")));		
		String expectedCheckOutPageTitle = driver.getTitle();
		if(expectedCheckOutPageTitle.equals(prop.getProperty("checkouttitle")))
		{
			log.info("Check Title Matched and Verified");				
		}
	else
		{
		log.error("Check Title Not Matched so Not Verified");				
		}

	}
	
	@Test (dependsOnMethods="verifyCheckoutPage")
	public void CheckOutPage()
	{		
		CheckoutPage cp = new CheckoutPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 400);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='shipping-new-address-form']/div[1]/div/input")));
		cp.getFirstName().sendKeys(prop.getProperty("firstname"));
		cp.getLastName().sendKeys(prop.getProperty("lastname"));
		cp.getStreetName().sendKeys(prop.getProperty("streetaddress"));
		cp.getCity().sendKeys(prop.getProperty("city"));
		cp.getstate();
		cp.getzipcode().sendKeys(prop.getProperty("zipcode"));
		cp.getEmail().sendKeys(prop.getProperty("email"));
		cp.getPhoneNumber().sendKeys(prop.getProperty("phone"));
		cp.clickOnContinueToPayment().click();
	}
	
	@Test (dependsOnMethods="CheckOutPage")
	public void ProceedToPayment() throws InterruptedException

	{
		PaymentPage pp = new PaymentPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 400);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='braintree']")));
		pp.clickRadioButton().click();
		pp.getCardName().clear();
		pp.getCardName().sendKeys(prop.getProperty("Nameofcard"));
		pp.getCardNumber().sendKeys(prop.getProperty("cardnumber"));
		pp.getMonth();
		pp.getYear();
		pp.getCVV().sendKeys(prop.getProperty("cvv"));
		pp.clickPlaceOrder().click();
		Thread.sleep(15000);
		Alert alert =  driver.switchTo().alert();
		alert.getText();
		alert.accept();
		}
	
	@AfterTest
	public void driverClosed() 
	{
		driver.manage().deleteAllCookies();

		driver.quit();

	}
	
	
}
