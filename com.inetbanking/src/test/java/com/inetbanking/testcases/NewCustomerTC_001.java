package com.inetbanking.testcases;

import java.time.Duration;

import org.openqa.selenium.By;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.PageObject.HomePage;
import com.inetbanking.PageObject.LoginPage;
import com.inetbanking.PageObject.NewCustomerPage;
import com.inetbanking.testbase.TestBase;

public class NewCustomerTC_001 extends TestBase {
	
	NewCustomerPage NewCustomer;
	int row=1;

//	@Test(priority=1)
//	public void verifyNewCustomerTC_001()
//	{
//		LoginPage login = new LoginPage (driver);
//		login.setUsername(excelDataProvider.getStringcellData("Login", 1, 0));
//		login.setPassword(excelDataProvider.getStringcellData("Login", 1, 1));

//		HomePage homepage = login.clickOnLoginBtn();

//		NewCustomerPage newcustomer = homepage.clickOnNewCustomerlink();
//		String actTitle = newcustomer.verifyNewCustomerPage();
  //		String expTitle = "Guru99 Bank New Customer Entry Page";

//		System.out.println(actTitle);

//		if (actTitle.contains("NewCustomer")) {

//			Assert.assertTrue(true);
//			System.out.println("Navigated to"+driver.getTitle());
//		}else {
//			Assert.assertTrue(true);
//	 }
//	}
	
//	@Test(priority=2)
//	public void createNewCustomerTC_002()
//	{
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		
//		NewCustomer.setCustomerName("Akash");
//		NewCustomer.selectGender("Male");
//		NewCustomer.setDOB("25-05-1995");
//		NewCustomer.setAddress("Gurudwara road pune");
//		NewCustomer.setcity("Pune");
//		NewCustomer.setstate("maharashtra");
//		NewCustomer.setPIN("411033");
//		NewCustomer.setmobile("8999960982");
//		NewCustomer.setemail("akashj23@gmail.com");
//		NewCustomer.setpassword("Akash@123");
//		NewCustomer.clickOnsubmit();
		
		
//	    String successmsg = driver.findElement(By.xpath("//p[text()='Customer Registered successfully !!!']")).getText();
		
//		System.out.println(successmsg);
		
//		String customerID = driver.findElement(By.xpath("//table[@id='customer']/+body/tr[4]/+d[2]")).getText();
		
//		System.out.println(customerID);
			
//	}
	

    @Test(dataProvider ="fetchExcelTestData")
    public void createNewCustomerTC_002(String CustomerName,String Gender,String DOB,String Address,String City,String State,String Pin,String Mobile,String Email,String Password)
    {
//   	System.out.println(CustomerName+"  "+Gender+"  "+DOB+"  "+Address+"  "+City+"  "+State+"  "+Pin+"  "+Mobile+"  "+Email+"  "+Password);
    	
    	LoginPage login = new LoginPage (driver);
		login.setUsername(excelDataProvider.getStringcellData("Login", 1, 0));
		login.setPassword(excelDataProvider.getStringcellData("Login", 1, 1));

		HomePage homepage = login.clickOnLoginBtn();

		NewCustomerPage NewCustomer = homepage.clickOnNewCustomerlink();
    	
    	NewCustomer.setCustomerName(CustomerName);
		NewCustomer.selectGender(Gender);
		NewCustomer.setDOB(DOB);
		NewCustomer.setAddress(Address);
		NewCustomer.setcity(City);
		NewCustomer.setstate(State);
		NewCustomer.setPIN(Pin);
		NewCustomer.setmobile(Mobile);
		NewCustomer.setemail(Email);
		NewCustomer.setpassword(Password);
		NewCustomer.clickOnsubmit();
		

		
	    String successmsg = driver.findElement(By.xpath("//p[text()='Customer Registered successfully !!!']")).getText();
		
		System.out.println(successmsg);
		
		String customerID = driver.findElement(By.xpath("//table[@id='customer']/+body/tr[4]/+d[2]")).getText();
		
		System.out.println(customerID);
		
		
		try {
			excelDataProvider.setStringCelldata("newCustomer",row,customerID);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		row = row+1;
       
//		 Newcustomer = homepage.clickOnNewCustomerlink();
    }
    @DataProvider
    public String [][] fetchExcelTestData()
    {
    	String[][] data = excelDataProvider.getExcelTestData("newCustomer");
    	return data ;
    }
}




















