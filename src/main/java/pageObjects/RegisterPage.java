package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {

public WebDriver driver;
	
	
	By fullname =  By.id("user_name");
	By email = By.name("email");
	By password = By.cssSelector("input[type='password']");
	By checkbox1 = By.cssSelector("input[type='checkbox']");
	By submit = By.cssSelector("input[type='submit']");
	
	public RegisterPage (WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	
	public WebElement getFullname()
	{
		return driver.findElement(fullname);
	}
	
	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	
	public WebElement getPassword()
	{
		return driver.findElement(password);
		
	}
	
	public WebElement getCheckbox()
	{
		return driver.findElement(checkbox1);
	}

	public WebElement getSubmit()
	{
		return driver.findElement(submit);
	}
	
}
