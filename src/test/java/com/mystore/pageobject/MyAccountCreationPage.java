package com.mystore.pageobject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccountCreationPage {

	WebDriver ldriver;
	  public WebDriverWait wait;
	//Constructor
	public MyAccountCreationPage(WebDriver rdriver) {
		
		ldriver =rdriver;
		PageFactory.initElements(rdriver, this);
		wait = new WebDriverWait(ldriver, Duration.ofSeconds(10)); 
	}
	
	@FindBy(id = "id_gender2") //Title-Mrs
	WebElement titleMrs;
	
	@FindBy(id = "id_gender1") //Title-Mrs
	WebElement titleMr;
	
	@FindBy(id="customer_firstname")
	WebElement custfirstName;

	@FindBy(id="customer_lastname")
	WebElement custlastName;
   
	@FindBy(id="passwd")
	WebElement password;
	
	@FindBy(id="submitAccount")
	WebElement register;
	
	@FindBy(xpath = "//body/div[@id='page']/div[@class='columns-container']/div[@id='columns']/div[@class='row']/div[@id='center_column']/div[1]")
    WebElement errorMessage;
	
	
	@FindBy(xpath = "//a[@title='View my customer account']") 
	WebElement userName;
	
	  
	
	public void selectTitleMrs() {
		titleMrs.click();
	}
	
	public void selectTitleMr()
	{
		titleMr.click();
	}
	public void enterCustomerFirstName(String fname)
	{
		custfirstName.sendKeys(fname);
	}

	public void enterCustomerLastName(String lname)
	{
		custlastName.sendKeys(lname);
	}

	public void enterPassword(String pwd)
	{
		password.sendKeys(pwd);
	}
	
	public void clickOnRegister()
	{
		register.click();
	}
	
    public boolean isUserAccountDisplayed() {
        try {
            return userName.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    
    public String getusername() {
		String text =userName.getText();
		return text;
	}


    public boolean isErrorMessageDisplayed() {
        try {
            return errorMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getErrorMessageText() {
        try {
            return errorMessage.getText();
        } catch (Exception e) {
            return "";
        }
    }
}
