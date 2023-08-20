package com.inetbanking.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewCustomerPage {

     WebDriver driver;
	
	//Object repository for the new customer page
	
	@FindBy(name ="name")
	WebElement txt_NewCustomer;
	
	@FindBy(xpath ="//input[@type='radio' and @value ='m']")
	WebElement MaleradioBtn;
	
	@FindBy(xpath ="//input[@type='radio' and @value ='f']")
	WebElement FemaleradioBtn;
	
	@FindBy(name ="dob")
	WebElement txt_dob;
	
	@FindBy(name ="addr")
	WebElement txt_Address;
	
	@FindBy(name ="City")
	WebElement txt_City;
	
	@FindBy(name ="state")
	WebElement txt_State;
	
	@FindBy(name ="pinno")
	WebElement txt_Pin;
	
	@FindBy(name ="telephoneno")
	WebElement txt_Mobile;
	
	@FindBy(name ="emailid")
	WebElement txt_Email;
	
	@FindBy(name ="Password")
	WebElement txt_Password;
	
	@FindBy(name ="sub")
	WebElement submitBtn;

	public NewCustomerPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	public String verifyNewCustomerPage() {

		return driver.getTitle();
	}
	
	public void setCustomerName(String CustomerName)
	{
		txt_NewCustomer.clear();
		txt_NewCustomer.sendKeys(CustomerName);
	}
	
	public void selectGender(String gender)
	{
		if(gender.equals("Male"))
		{
			MaleradioBtn.click();
		}else {
			FemaleradioBtn.click();
		}
	}
	public void setDOB (String dob)
	{
		String [] date = dob.split("-");
		String day = date[0];
		String month = date[1];
		String year = date[2];
		
		
		txt_dob.sendKeys(day);
		txt_dob.sendKeys(month);
		txt_dob.sendKeys(year);
	}
	public void setAddress(String address)
	{
		txt_Address.clear();
		txt_Address.sendKeys(address);
	}
	public void setcity(String city)
	{
		txt_City.clear();
		txt_City.sendKeys(city);
	}
	public void setstate(String state)
	{
		txt_State.clear();
		txt_State.sendKeys(state);
	}
	public void setPIN(String PIN)
	{
		txt_Pin.clear();
		txt_Pin.sendKeys(PIN);
	}
	public void setmobile(String mobile)
	{
		txt_Mobile.clear();
		txt_Mobile.sendKeys(mobile);
	}
	public void setemail(String email)
	{
		txt_Email.clear();
		txt_Email.sendKeys(email);
	}
	public void setpassword(String password)
	{
		txt_Password.clear();
		txt_Password.sendKeys(password);
	}
	public void clickOnsubmit()
	{
		try {
			Thread.sleep(2000);
			submitBtn.click();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
	}
	

}
