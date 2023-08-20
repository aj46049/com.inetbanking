package com.inetbanking.testcases;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.PageObject.LoginPage;
import com.inetbanking.testbase.TestBase;

public class Login_001 extends TestBase {
	
//	User ID :	mngr503012
//	Password :	temajag
	
	
	@Test
    public void verifyloginPageTitleTC_001()
	{
		driver.findElement(By.name("uid")).sendKeys("mngr503012");
		driver.findElement(By.name("password")).sendKeys("temajag");		
		driver.findElement(By.name("btnLogin")).click();
		String expTitle ="Guru99 Bank Manager Home Page";
		String actTitle = driver.getTitle();
		System.out.println(actTitle);
		
		if(expTitle.equals(actTitle))
	     {
			Assert.assertTrue(true);
		}else {
		Assert.assertTrue(false);
		}
		
	}
    
//	@Test
//	public void verifyLoginFunctionalityTC_002()
//	{
//		LoginPage login =new LoginPage(driver);
//		login.setUsername("mngr503012");
//		login.setPassword("temajag");
		
//		login.clickOnLoginBtn();
		
//		String expTitle ="Guru99 Bank Manager HomePage";
//		String actTitle = driver.getTitle();
//		if (expTitle.equals(actTitle)) {
//			Assert.assertTrue(true);
//		}else {
//			Assert.assertTrue(false);
//	    	}
//  	}
//	}	
	
	
//	@Test
//	public void verifyLoginFunctionalityTC_002()
//	{
//		LoginPage login =new LoginPage(driver);
//		login.setUsername(configDataProvider.getUsername());
//		login.setPassword(configDataProvider.getPassword());
		
//		login.clickOnLoginBtn();
		
//		String expTitle ="Guru99 Bank Manager HomePage";
//		String actTitle = driver.getTitle();
//		if (expTitle.equals(actTitle)) {
//			Assert.assertTrue(true);
//		}else {
//			Assert.assertTrue(false);
//		}
		
//		Assert.assertEquals(actTitle, expTitle,"actual browser title doesn't matched with expected title");
//	}
	
}
