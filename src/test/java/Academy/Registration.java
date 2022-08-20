package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.RegisterPage;

import resources.base;

public class Registration extends base{
	public WebDriver driver;
	public static Logger log =LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initilize() throws IOException
	{
		driver = initializeDriver();
		log.info("Home page Driver is initilize");
		driver.manage().window().maximize();
		
		
	}
	
	
	@Test(dataProvider = "getData2")
	
public void registerNewUser(String Firstname, String EmailAddress, String Pass) throws IOException 
	{
		driver.get(prop.getProperty("url"));
		LandingPage l = new LandingPage(driver);
		//l.getClosein().click();
		l.getRegister().click();
		RegisterPage r = new RegisterPage(driver);
		
		r.getFullname().sendKeys(Firstname);
		r.getEmail().sendKeys(EmailAddress);
		r.getPassword().sendKeys(Pass);
		r.getCheckbox().click();
		r.getSubmit().click();
		//log.info("Registration successfully completed");
		log.info("Reg succesfully");
		driver.get(prop.getProperty("singupurl"));
	}
	
	@DataProvider
	
	
		public Object[][] getData2()
		{
		
			Object [][] data = new Object [2][3];
			
			//0th row
			data [0][0] = "KKK";
			data [0][1] = "abc@test.com";
			data [0][2] = "Invalid Registration";
			
			//1st row
			data [1][0] = "Nikit";
			data [1][1] = "nikit.umb@yopmail.com";
			data [1][2] = "Valid Registration";
			
			return data;
	}
	
	
	
	@AfterTest
	public void teardrow()
	{
		driver.close();
	}
	
}
