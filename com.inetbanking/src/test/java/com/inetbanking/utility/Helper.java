package com.inetbanking.utility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {
	
	
	public static void captureScreenshot(WebDriver driver)
	{
		try {
			TakesScreenshot ts = (TakesScreenshot)driver;
			File scr = ts.getScreenshotAs(OutputType.FILE);
			File target = new File ("./Screenshots/inetBanking_"+getCurrentDateTime()+".png");
			FileHandler.copy(scr, target);
						
//			FileHandler.copy((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE), new File(./Screenshots/inetBanking_"+getCurrentDateTime()+".png"));
		    
			System.out.println("Captured Screenshots Successfully!!!!");
		}catch(Exception e) {
			System.out.println("Exception raised in try block :-"+e);
		}
		
	}
	
	public static void handleAlertPopUp(WebDriver driver)
	{
		if (isAlertPresent(driver))
		{
			Alert alert = driver.switchTo().alert();
			System.out.println(alert.getText());
			alert.accept();
		}else {
			System.out.println("Alert PopUp not exists...!!!!");
		}
	}
    public static boolean isAlertPresent(WebDriver driver)
    {
    	try {
    		driver.switchTo().alert();
    		return true;
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    		return false;
    	}
    }
    public static String getCurrentDateTime()
    {
    	return new SimpleDateFormat("mm_dd_yyyy_HH_mm_ss").format(new Date());
    }


}
