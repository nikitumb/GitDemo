package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;


import pageObjects.LandingPage;

import resources.base;

public class validateNavigationBar extends base{
	public WebDriver driver;
	public static Logger log =LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initilize() throws IOException
	{
		driver = initializeDriver();
		log.info("Valiodate Navigation Driver is initilize");
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		log.info("Valiodate Navigation to HOME PAGE");
	}
	
	
	@Test
	
	public void validateNavigation() throws IOException
	{
		LandingPage l = new LandingPage(driver);
		//System.out.println(l.getTitle().getText());
		Assert.assertTrue(l.getNavbar().isDisplayed());
			
	}
	
	@AfterTest
	public void teardrow()
	{
		driver.close();
	}
	
	
}
