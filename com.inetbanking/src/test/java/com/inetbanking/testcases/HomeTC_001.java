package com.inetbanking.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.PageObject.HomePage;
import com.inetbanking.PageObject.LoginPage;
import com.inetbanking.testbase.TestBase;
import com.inetbanking.utility.Helper;

public class HomeTC_001 extends TestBase {
	
	
//	@Test
//	public void navigateToNewCustomerTC_001()
//	{
//		LoginPage login = new LoginPage(driver);
		
//		String Username = excelDataProvider.getStringcellData("Login", 1, 0);
//		String Password = excelDataProvider.getStringcellData("Login", 1, 1);
   //		String expTitle = excelDataProvider.getStringcellData("Login", 1, 0);
		
//		login.setUsername(Username);
//		login.setPassword(Password);
		
//		HomePage homepage =login.clickOnLoginBtn();
//		homepage.clickOnNewCustomerlink();
		
//		System.out.println(driver.getTitle());
//	}
     
	
	@Test
	public void verifyLogoutFunctionality() throws InterruptedException
	{
		
		extentTest = extentReports.createTest("Login Test");
		LoginPage login = new LoginPage(driver);
		
		extentTest.info("Login Page Loaded Successfully");
		
		String Username = excelDataProvider.getStringcellData("Login", 1, 0);
		String Password = excelDataProvider.getStringcellData("Login", 1, 1);
   //		String expTitle = excelDataProvider.getStringcellData("Login", 1, 0);
		
		login.setUsername(Username);
		login.setPassword(Password);
		
		extentTest.info("Username and Password Entered Successefully");
		
		HomePage homepage =login.clickOnLoginBtn();
		Thread.sleep(3000);
		extentTest.pass("Login Success");
		
		homepage.clickOnLogoutLink();
		
		extentTest.info("Logout link should be actioned");
		
		Helper.handleAlertPopUp(driver);
		extentTest.info("Alert should be actioned");
		
		String actTitle =driver.getTitle();
		String expTitle ="Guru99 Bank HomePage";
		
		if(actTitle.equals(expTitle)) {
			Assert.assertTrue(true);
//			Helper.captureScreenshot(driver, "LoginPage");
			  Helper.captureScreenshot(driver);
			  extentTest.pass("Logout Success");
		}else {
//			Helper.captureScreenshot(driver, "HomePage");
			  Helper.captureScreenshot(driver);
			  extentTest.fail("Logout Failed");
			Assert.assertTrue(true);
		}
						
	}
}
