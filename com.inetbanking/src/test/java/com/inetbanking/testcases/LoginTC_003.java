package com.inetbanking.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.PageObject.LoginPage;
import com.inetbanking.testbase.TestBase;

public class LoginTC_003 extends TestBase {
	
	@Test
	public void verifyLoginFunctionalityTC_003() {
		
		LoginPage login = new LoginPage (driver);
		
		String Username =excelDataProvider.getStringcellData(0, 1, 0);
		String Password = excelDataProvider.getStringcellData(0, 1, 2);
		String expTitle = excelDataProvider.getStringcellData(0, 1, 2);
		
		
		login.setUsername(Username);
		login.setPassword(Password);
		
		login.clickOnLoginBtn();
		
		if(expTitle.equals(driver.getTitle())) {
			Assert.assertTrue(true);
			System.out.println("Login Success !!!!!");
		}else {
			System.out.println("Login Failed !!!!!");
			Assert.assertTrue(false);
		}
	}

}
