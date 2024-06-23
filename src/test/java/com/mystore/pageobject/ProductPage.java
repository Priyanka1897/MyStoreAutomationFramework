package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductPage {

	WebDriver ldriver;

	public ProductPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);//driver that will be used to lookup the web element

	}

	@FindBy(id="quantity_wanted")
	WebElement quantityWanted ;
	
	@FindBy(id="group_1")
	WebElement size;
	
	@FindBy(name="Submit")
	WebElement addToCart;
	
	@FindBy(linkText = "Proceed to checkout")
	WebElement proceed;
	
	public void setQuantity(String qty)
	{
		quantityWanted.clear();
		quantityWanted.sendKeys(qty);
	}

	public void setsize(String sizetype) {
		
		Select dresssize1=new Select(size);
		dresssize1.selectByVisibleText(sizetype);
	}
	
	public void clickOnAddToCart()
	{
		addToCart.click();
	}
	
	public void clickOnProceedToCheckOut()
	{
		proceed.click();
	}

}
