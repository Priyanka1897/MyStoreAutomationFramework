package com.mystore.pageobject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPaymentPage {
	WebDriver ldriver;
	
	public OrderPaymentPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);//driver that will be used to lookup the web element
	}

	@FindBy(xpath = "//a[@title='Pay by check.']")
	WebElement payByCheque;
	
	
	public String getPageTitle()
	{
		return (ldriver.getCurrentUrl());
	}
	
	public void clickOnPayByCheque()
	{
		payByCheque.click();
	}

}
