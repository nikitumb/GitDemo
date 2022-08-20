package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class base {
	
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException
	{
		prop = new Properties();
		// give the path dynamically
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
	
		prop.load(fis);
		// mvn test -Dbrowser=chrome
		
		String browserName = System.getProperty("browser"); // this we used to execute project by selecting browser directly from maven and not from the base file
		
		//String browserName = prop.getProperty("browser");
		System.out.println(browserName);		
		
		if(browserName.contains("chrome"))
		{
			// Give driver path dynamically in prject, copy all drivers in Project>Resoruces filder and set the path
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\\\src\\\\main\\\\java\\\\resources\\chromedriver.exe");
			//driver= new ChromeDriver();
			
			// below code is to run the project with and without hedless mode
			// In jenkins > Configure > Add healess parameter and set the property for headless execution
						
			ChromeOptions option = new ChromeOptions();
			if(browserName.contains("headless"))
			{
				option.addArguments("headless");
				
			}
			
			driver= new ChromeDriver(option);	
			
			
		}
		else if(browserName.equals("FireFox"))
		{
			//firefox
		}
		else if(browserName.equals("IE"))
		{
			//IE
		}
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	return driver;
	
	}
	
	public String getScreenshotPath(String Testcasename, WebDriver driver) throws IOException
	{
	TakesScreenshot ts = (TakesScreenshot) driver;
	try {
	File source = ts.getScreenshotAs(OutputType.FILE);
	String destinationFile = System.getProperty("user.dir")+"\\reports\\"+ Testcasename+".png";
	FileUtils.copyFile(source, new File(destinationFile));
	return destinationFile;
	}
	catch (Exception e)
	{
		e.printStackTrace();
	}
	return Testcasename;
	
	}
	
	
	
	
	
	
}
