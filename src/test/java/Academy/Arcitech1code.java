package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WrapsDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base{
	public WebDriver driver;
	public static Logger log =LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initilize() throws IOException
	{
		driver = initializeDriver();
		log.info("Home page Driver is initilize");
		driver.manage().window().maximize();
		
	}
	
	
	@Test(dataProvider = "getData")
	
	public void basePageNavigation(String Username, String Password, String text) throws IOException
	{
		// this is architech #1 code merged in DEVELOP branch
		
		
	}
	
	@DataProvider
	
	public Object[][] getData()
	{
	
		// this is architech #1 code merged in DEVELOP branch				
	}
	
	@AfterTest
	public void teardrow()
	{
				// this is architech #1 code merged in DEVELOP branch
	}
	
}
