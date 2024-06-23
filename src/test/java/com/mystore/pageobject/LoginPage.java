package com.mystore.pageobject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	WebDriver ldriver;
	//Constructor
	public LoginPage(WebDriver rdriver) {
		
		ldriver =rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id = "email") 
	WebElement registeredUsersEmail;
	
	@FindBy(id = "passwd") 
	WebElement registeredUsersPwd;
	
	@FindBy(id = "SubmitLogin")
	WebElement submitLogin;
	
    
	@FindBy(xpath="//body/div[@id='page']/div[@class='header-container']/header[@id='header']/div/div[@class='container']/div[@class='row']/div[@id='block_top_menu']/ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li[2]/a[1]")
	WebElement dresses;
	
	@FindBy(xpath = "//a[@title='Log me out']")
	WebElement signOut;
	
	
	public void enterEmailAddress(String emailAdd) 
	{
		registeredUsersEmail.sendKeys(emailAdd);
	}

	public void enterPassword(String pwd) 
	{
		registeredUsersPwd.clear();
		registeredUsersPwd.sendKeys(pwd);
	}

	
	public void clickSignIn()
	{
		submitLogin.click();
	}
	

	
	public void Mousehoverdresses() {
		WebDriverWait wait = new WebDriverWait(ldriver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(dresses));
		Actions act = new Actions(ldriver);
		act.moveToElement(dresses).build().perform();
	}
	
	public void clickOnSignOut()
	{
		signOut.click();
	}

}
