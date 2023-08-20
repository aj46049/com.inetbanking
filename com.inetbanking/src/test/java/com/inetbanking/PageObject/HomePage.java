package com.inetbanking.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
     

	WebDriver driver;
	
	
	@FindBy(linkText="New Customer")
	WebElement NewCustomerlink;
	
	@FindBy(linkText="Edit Customer")
	WebElement EditCustomerLink;
	
	@FindBy(linkText="Log out")
	WebElement LogoutLink;
	
	
	public HomePage(WebDriver driver) 
	{
		this.driver =driver;
		PageFactory.initElements(driver, this);
		
	}
	public  NewCustomerPage clickOnNewCustomerlink()
	{
	      NewCustomerlink.click();
	      return new NewCustomerPage(driver);
	}
   
	public EditCustomerPage clickOnEditCustomerLink()
	{
		EditCustomerLink.click();
		return new EditCustomerPage(driver);
	}
	public NewCustomerPage clickOnEditCustomerlink() {
		// TODO Auto-generated method stub
		return null;
	}
	public void clickOnLogoutLink()
	{
		LogoutLink.click();
	}
}
