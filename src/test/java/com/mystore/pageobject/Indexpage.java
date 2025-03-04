package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Indexpage {
 
	WebDriver ldriver;
	//Constructor
	public Indexpage(WebDriver rdriver) {
		
		ldriver =rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	//find webelements
	@FindBy(linkText = "Sign in") 
	WebElement signIn;
	
	public void clickOnSignIn() {
		signIn.click();
	}
	
	
}
