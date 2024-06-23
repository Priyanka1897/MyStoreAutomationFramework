package com.mystore.utilites;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;



public class ReadConfig {
   public static WebDriver driver;
   public static Properties prop;
   
  
   public ReadConfig() {
	   
	try {
		FileInputStream fis = new FileInputStream("C:\\Users\\Hp\\eclipse-workspace\\MyStoreAutomationFramework\\Repository\\config.properties");
		 prop =new Properties();
		   prop.load(fis);
	} catch (Exception e) {
		
		e.printStackTrace();	   
   }
   }
	
		
	public String getBaseUrl(){
		String value = prop.getProperty("url");

		if(value!=null)
			return value;
		else
			throw new RuntimeException("url not specified in config file.");

	}

	public String getBrowser()
	{
		String value = prop.getProperty("browser");

		if(value!=null)
			return value;
		else
			throw new RuntimeException("url not specified in config file.");

	}
 
	public String getemail()
	{
		String email = prop.getProperty("email");

		if(email!=null)
			return email;
		else
			throw new RuntimeException("email not specified in config file.");

	}
	
	public String getpassword()
	{
		String password = prop.getProperty("password");

		if(password!=null)
			return password;
		else
			throw new RuntimeException("password not specified in config file.");

	}
	

}


