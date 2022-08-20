package stepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.junit.Cucumber;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.PortalHomePage;
import resources.base;

@RunWith(Cucumber.class)
public class stepDefination extends base {
	
	
	@Given("^Initialize the browser with chrome$")
	public void Initialize_the_browser_with_chrome() throws Throwable {
		
		System.setProperty("webdriver.chrome.driver", "D:/Automation/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
	}

	@And("^Navigate to the \"([^\"]*)\" site$")
	public void navigate_to_the_something_site(String strArg1) throws Throwable {
		
		driver.get(strArg1);
	}

	@And("^Click on Login link in home page to land on secure sing in page$")
	public void click_on_login_link_in_home_page_to_land_on_secure_sing_in_page() throws Throwable {
		
		LandingPage l = new LandingPage(driver);
		
		
		
		
	}
	
	 @When("^User enters (.+) and (.+) and logs in $")
	    public void user_enters_and_and_logs_in(String username, String password) throws Throwable {
		 LoginPage lp  = new LoginPage(driver);
			lp.getEmail().sendKeys(username);
			lp.getPassword().sendKeys(password);
			lp.getLogin().click();
			//System.out.println(text);
	    }
	
	

	@Then("^Verify that user is successfully logged in$")
	public void verify_that_user_is_successfully_logged_in() throws Throwable {
		
		PortalHomePage p = new PortalHomePage(driver);
		Assert.assertTrue(p.getSearchbox().isDisplayed());
	}
	@And("^Close browsers$")
    public void close_browsers() throws Throwable {
       driver.close();
    }


}