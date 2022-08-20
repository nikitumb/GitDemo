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
		driver.get(prop.getProperty("url"));
		log.info("HOME PAGE navigation");
		LandingPage l = new LandingPage(driver);
		LoginPage lp = l.getLogin();
		
		//LoginPage lp = new LoginPage(driver);
		
		lp.getEmail().sendKeys(Username);
		lp.getPassword().sendKeys("Password");
		lp.getLogin().click();
		//System.out.println(text);
		log.info(text);
		ForgotPassword fp = lp.getForgotPassword();
		fp.getEmail().sendKeys("xyz@test.com");
		fp.sendMeInstructions().click();
		
		
	}
	
	@DataProvider
	
	public Object[][] getData()
	{
	
		Object [][] data = new Object [2][3];
		
		//0th row
		data [0][0] = "nonrestrected@user.com";
		data [0][1] = "123123123";
		data [0][2] = "Non Restrected user";
		
		//1st row
		data [1][0] = "restrected@user.com";
		data [1][1] = "abcded";
		data [1][2] = "Restrected user";
		
		return data;
				
	}
	
	@AfterTest
	public void teardrow()
	{
		driver.close();
	}
	
}
