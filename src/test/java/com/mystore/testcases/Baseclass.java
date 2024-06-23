package com.mystore.testcases;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.mystore.utilites.ReadConfig;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {

	ReadConfig readconfig =new ReadConfig();

	String url =readconfig.getBaseUrl();
	String browser =readconfig.getBrowser();
	String email =readconfig.getemail();
	String password =readconfig.getpassword();
	public static WebDriver driver;

	public static Logger logger;

	@BeforeClass
	public void setup() {

		if(browser.equals("chrome")) {
		
		  driver = new ChromeDriver();	
			}else if(browser.equals("firefox")){
		
			driver = new FirefoxDriver();	
			}else if(browser.equals("Edge")){
			
			driver = new EdgeDriver();	
			}else {
				System.out.println("Please intialize proper browser");
			}
		

	        // Logging setup
	        logger = LogManager.getLogger("MyStoreV1");

	 
		//for logging
		//implicit wait of 3mins
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		logger = LogManager.getLogger("MyStoreV1");
		driver.get(url);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60)); // Example: 30 seconds
		logger.info("url opened");
		driver.manage().window().maximize();
		logger.info("window maximized");
       
	


	}

/*	@AfterClass
	public void teardown() {
		
		driver.quit();
	}*/

	//Method to capture the screenshot
     public void captureScreenshot(WebDriver driver, String screenshotname) {
    	//step1: convert webdriver object to TakesScreenshot interface
    	 TakesScreenshot screenshot = ((TakesScreenshot)driver);
    	 
    	 //step2: call getScreenshotAs method to create image file
    	 File src =screenshot.getScreenshotAs(OutputType.FILE);
    	 
    	 File dest = new File(System.getProperty("user.dir")+ "\\Screenshots\\" + screenshotname + ".png");
    	 
    	 //copy image file to destination
    	 try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     }


}
