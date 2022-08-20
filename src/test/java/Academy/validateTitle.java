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


public class validateTitle extends base{
	public WebDriver driver;
	LandingPage l;
	public static Logger log =LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initilize() throws IOException
	{
		driver = initializeDriver();
		log.info("Validate title Driver is initilize");
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		log.info("Validate title Navigated to HOME PAGE");
	}
	
	
	@Test
	
	public void titleBar() throws IOException
	{
		 l = new LandingPage(driver); // declear this globally so that we can skip this here. 
		 // We are using above step and we need to open browser once and perform multiple test cases on same browser without opending new browser
		//System.out.println(l.getTitle().getText());
		Assert.assertEquals(l.getTitle().getText(), "Featured cources123");
		log.error("test case fail");
		
	}
	
	
	@Test
	
	public void validateHeader() throws IOException
	{
		 //l = new LandingPage(driver); // No need to  
		//System.out.println(l.getTitle().getText());
		Assert.assertEquals(l.getHeader().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
		
		
	}
	
	
	@AfterTest
	public void teardrow()
	{
		driver.close();
	}
	
	
}
