package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {
	public WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException, InterruptedException
	{
		//property object to get the fix information from the properties file
		prop = new Properties();
		FileInputStream fle = new FileInputStream(".\\src\\main\\java\\resources\\data.properties");
		prop.load(fle);
		String browserName = prop.getProperty("browser");
		//Automate that which browser you want to run the script
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", ".\\chromedriver.exe");
			System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
			driver = new ChromeDriver();

		}
		else if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",".\\geckodriver.exe");
			driver = new FirefoxDriver();

		}
		//define wait for script for 7 sec to load any test case to get Failed globally
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			return driver;
	}

}
