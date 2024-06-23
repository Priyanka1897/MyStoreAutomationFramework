package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OrderSignupPage {
	WebDriver ldriver;

	//2. Create constructor
	public OrderSignupPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);//driver that will be used to lookup the web element

	}
	
	@FindBy(id ="address1")
	WebElement Address;
	
	@FindBy(id ="city")
	WebElement City;

	@FindBy(id ="id_state")
	WebElement State;
     
	@FindBy(id="postcode")
	WebElement postcode;
	
	/*@FindBy(id="id_country")
	WebElement country;*/

	//phone_mobile
	@FindBy(id="phone_mobile")
	WebElement phone_mobile;

	@FindBy(id="submitAddress")
	WebElement save;
	
	public void EnterAddress(String address) {
		Address.sendKeys(address);
	}

	public void EnterCity(String city) {
		City.sendKeys(city);
	}

	public void SelectState(String text) {
		Select obj= new Select(State);
		obj.selectByVisibleText(text);
	}


	public void enterPostcode(String postcodeData)
	{
		postcode.sendKeys(postcodeData);
	}

	/*public void selectCountry(String text)
	{
		Select obj = new Select(country);
		obj.selectByVisibleText(text);
	}*/

	public void enterMobilePhone(String mobile)
	{
		phone_mobile.sendKeys(mobile);
	}

	public void clickOnSave()
	{
		save.click();
	}
}
