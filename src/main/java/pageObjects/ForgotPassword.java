package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword {

		public WebDriver driver;
		
		By email = By.cssSelector("[id='user_email']");
		By sendinstructions = By.cssSelector("[type='submit']");
	
		
		
		public ForgotPassword(WebDriver driver) {
			
			this.driver=driver;
		}


		public WebElement getEmail()
		{
			return driver.findElement(email);
		}
		
		public WebElement sendMeInstructions()
		{
			return driver.findElement(sendinstructions);
		}
		
}
