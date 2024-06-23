package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderSummeryPage {

	
	WebDriver ldriver;

	//2. Create constructor
	public OrderSummeryPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);//driver that will be used to lookup the web element

	}


	@FindBy(linkText = "Proceed to checkout")
	WebElement proceed;
	
	
	
	
	public void cickOnProceedToCheckout()
	{
		proceed.click();
	}
	
}
