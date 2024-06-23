package com.mystore.testcases;

import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mystore.pageobject.Indexpage;
import com.mystore.pageobject.LoginPage;
import com.mystore.pageobject.MyAccountCreationPage;
import com.mystore.utilites.ReadExcelFile;

public class MyAccountDataDrivenTest extends Baseclass {
	
	@Test (dataProvider ="LoginDataProvider")

	public void VerifyLogin(String userEmail, String userPwd, String expectedUsername) throws Exception {
		logger.info("***************TestCase VerifyLogin starts*****************"); 
		Indexpage ip =new Indexpage(driver);
		Thread.sleep(3000);
		ip.clickOnSignIn();
		logger.info("Clicked on sign in link");
		
		LoginPage lp= new LoginPage(driver);
		lp.enterEmailAddress(userEmail);
		lp.enterPassword(userPwd);
		lp.clickSignIn();
		logger.info("User logged successfully");
		Thread.sleep(3000);
		 lp.Mousehoverdresses();
		 logger.info("Hovered on dresses");
		
		 MyAccountCreationPage accCreationPg =new MyAccountCreationPage(driver);
		 String userName =accCreationPg.getusername();
		
			if (userName.equalsIgnoreCase(expectedUsername)) {
				logger.info("User name matched successfully");
				Assert.assertTrue(true);
				lp.clickOnSignOut();
				
			}else {
				logger.info("Authentication failed");
				captureScreenshot(driver,"VerifyLogin");
				Assert.assertTrue(false);
			}	
			logger.info("***************TestCase Verify login ends*****************"); 
		
	}
	
	@DataProvider(name="LoginDataProvider")
	public String[][] LoginDataProvider() {
		
		String Filename=System.getProperty("user.dir") + "\\TestData\\MyStoreTestData.xlsx";
		int ttlrows= ReadExcelFile.getRowCount(Filename, "LoginTestData");
		int ttlcol= ReadExcelFile.getColCount(Filename, "LoginTestData");
		
		String data[][]=new String[ttlrows-1][ttlcol];
		for(int i=1;i<ttlrows;i++)//rows =1,2
		{
			for(int j=0;j<ttlcol;j++)//col=0, 1,2
			{

				data[i-1][j]=ReadExcelFile.getCellvalue(Filename,"LoginTestData", i,j);
			}

		}
		return data;
				
				
		
	}
	
}



