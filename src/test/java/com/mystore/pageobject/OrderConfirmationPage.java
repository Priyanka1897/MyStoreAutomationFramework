package com.mystore.pageobject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage {
	WebDriver ldriver;


	public OrderConfirmationPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);//driver that will be used to lookup the web element

	}

	@FindBy(xpath = "//button[@class='button btn btn-default button-medium']")
	WebElement confirmOrder;
	
	@FindBy(xpath="//p[@class='alert alert-success']")
	WebElement sucessAlert;
	
	public void cickOnConfirmOrder()
	{
		confirmOrder.click();
	}
	
	public String getOrderSucessMessage()
	{
		return(sucessAlert.getText());
	}
}
