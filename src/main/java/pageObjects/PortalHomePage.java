package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PortalHomePage {

		public WebDriver driver;
		
		By searchbox = By.name("query");
		
		
		
		public PortalHomePage(WebDriver driver) {
			
			this.driver=driver;
		}


		public WebElement getSearchbox()
		{
			return driver.findElement(searchbox);
		}
		
		
		
		
			
}
