package com.mystore.testcases;

import java.time.Duration;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.mystore.pageobject.Indexpage;
import com.mystore.pageobject.LoginPage;
import com.mystore.pageobject.MyAccountCreationPage;
import com.mystore.pageobject.MyAccountpage;
import com.mystore.pageobject.OrderAddressPage;
import com.mystore.pageobject.OrderConfirmationPage;
import com.mystore.pageobject.OrderPaymentPage;
import com.mystore.pageobject.OrderShippingPage;
//import com.mystore.pageobject.OrderSignupPage;
import com.mystore.pageobject.OrderSummeryPage;
import com.mystore.pageobject.ProductPage;
import com.mystore.pageobject.SearchResultPage;

public class My_AccountPageTest extends Baseclass{

	@Test(enabled=false)
	public void VerifyRegistrationAndLogin() throws Exception {
		Indexpage ip =new Indexpage(driver);
		Thread.sleep(3000);
		ip.clickOnSignIn();
		logger.info("Clicked on sign in link");
	
		MyAccountpage myaccount =new MyAccountpage(driver);
		myaccount.enteremail("priyanka18@yopmail.com");
		myaccount.ClickonSubmitCreate();
		
		
		MyAccountCreationPage accCreationPg =new MyAccountCreationPage(driver);
		accCreationPg.selectTitleMrs();
		accCreationPg.enterCustomerFirstName("Priyanka");
		accCreationPg.enterCustomerLastName("Chauhan");
		accCreationPg.enterPassword("Test@12345");
		logger.info("entered user details on account creation page.");
		accCreationPg.clickOnRegister();
		logger.info("clicked on Register button");
		
	//	String userName =accCreationPg.getusername();
	//	Assert.assertEquals("Priyanka Chauhan", userName);
		logger.info("***************TestCase Verify Registration and Login ends*****************"); 

	}
	
	@Test
	public void VerifyLogin() throws Exception {
		Indexpage ip =new Indexpage(driver);
		Thread.sleep(3000);
		ip.clickOnSignIn();
		logger.info("Clicked on sign in link");
		
		LoginPage lp= new LoginPage(driver);

		lp.enterEmailAddress(email);
		lp.enterPassword(password);
			
		lp.clickSignIn();
		MyAccountCreationPage accCreationPg =new MyAccountCreationPage(driver);
	   
		 if (accCreationPg.isUserAccountDisplayed()) {
	            logger.info("User logged in successfully");
	            String userName =accCreationPg.getusername();
				Assert.assertEquals("Priyanka Chauhan", userName);
				if (userName.equals("Priyanka Chauhan")) {
					logger.info("Correct user name showing");
					Assert.assertTrue(true);
				}else {
					logger.info("Wrong user name showing");
					captureScreenshot(driver,"VerifyLogin");
					Assert.assertTrue(false);
				}
	        } else {
	        	if (accCreationPg.isErrorMessageDisplayed()) {
	        	
	            String errorMsg = accCreationPg.getErrorMessageText();
	            logger.info(errorMsg+ "Authentication failed");
	            
	            captureScreenshot(driver, "VerifyLogin");
	         
	        	}
	        }
		
		
		 lp.Mousehoverdresses();
		 logger.info("Hovered on dresses");
		
			
			SearchResultPage sr= new SearchResultPage(driver);
			sr.search("Dresses");
			sr.ClickOnSearchButton();
			logger.info("Dresses results showing");
		  
			String text = sr.getSearchResultProductName();
			Assert.assertEquals("Printed Dress", text);
			logger.info("Printed Dress showing");
			sr.ClickOnResult();
			
			sr.ClickOnColor();
			logger.info("Pink color clicked");
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			ProductPage prodPg = new ProductPage(driver);
			prodPg.setQuantity("2");
			logger.info("quantity 2 entereed");

			prodPg.setsize("M");
			logger.info("size M entered");

			prodPg.clickOnAddToCart();
			logger.info("Clicked on add to cart");

			prodPg.clickOnProceedToCheckOut();
			logger.info("Clicked on proceed to checkout on product page");
		
			OrderSummeryPage orderSumPg = new OrderSummeryPage(driver);
			orderSumPg.cickOnProceedToCheckout(); 
			logger.info("Clicked on proceed to checkout on order summary page");
			
			
		/*	OrderSignupPage ordersignuppg= new OrderSignupPage(driver);
			ordersignuppg.EnterAddress("Abcd");
			ordersignuppg.EnterCity("Ghaziabad");
			ordersignuppg.SelectState("Indiana");
			ordersignuppg.enterPostcode("00000");
			ordersignuppg.enterMobilePhone("9891778192");
			ordersignuppg.clickOnSave();
			logger.info("clicked on Save button");*/

			OrderAddressPage orderAddPg = new OrderAddressPage(driver);
			orderAddPg.cickOnProceedToCheckout();
			logger.info("Clicked on proceed to checkout on order address page");
			
			OrderShippingPage orderShippingPg = new OrderShippingPage(driver);
			orderShippingPg.selectTermsOfServices();
			logger.info("selecged term of service check box");

			orderShippingPg.cickOnProceedToCheckout();
			logger.info("Clicked on proceed to checkout on order shipping page");
			
			OrderPaymentPage orderPaymentPg = new OrderPaymentPage(driver);
			logger.info(orderPaymentPg.getPageTitle());

			orderPaymentPg.clickOnPayByCheque();
			logger.info("Clicked on pay by cheque");
           
			OrderConfirmationPage orderConfirmPg = new OrderConfirmationPage(driver);
			orderConfirmPg.cickOnConfirmOrder();

			logger.info("Clicked on confirmed order");

			String sucessMsg = orderConfirmPg.getOrderSucessMessage();

			if(sucessMsg.equals("Your order on My Shop is complete."))
			{
				logger.info("VerifyBuyProduct - Passed"); 
				Assert.assertTrue(true);

			}
			else
			{
				logger.info("VerifyBuyProduct - Failed");
				captureScreenshot(driver,"VerifyBuyProduct");
				Assert.assertTrue(false);

			} 

			logger.info("***************TestCase BuyProduct ends*****************"); 
	}
	
	
	
}
