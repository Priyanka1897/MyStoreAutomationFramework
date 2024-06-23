package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountpage {


	WebDriver ldriver;
	//Constructor
	public MyAccountpage(WebDriver rdriver) {

		ldriver =rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id="email_create")
	WebElement Emailcreate;
	
	@FindBy(id="SubmitCreate")
	WebElement SubmitCreate;
	
	public void enteremail(String enteremailcreate) {

		Emailcreate.sendKeys(enteremailcreate);
	}

	public void ClickonSubmitCreate() {
		SubmitCreate.click();
	}
	
	
	
}
