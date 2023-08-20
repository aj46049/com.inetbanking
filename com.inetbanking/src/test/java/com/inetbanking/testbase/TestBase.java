package com.inetbanking.testbase;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.inetbanking.utility.ConfigDataProvider;
import com.inetbanking.utility.ExcelDataProvider;
import com.inetbanking.utility.Helper;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TestBase {
	
	public static WebDriver driver;
	public ConfigDataProvider configDataProvider;
	public ExcelDataProvider excelDataProvider;
	public ExtentHtmlReporter extentHtmlReporter;
	public ExtentReports extentReports;
	public ExtentTest extentTest;
	
//	static String appUrl="https://demo.guru99.com/V4/index.php";
	
	@BeforeSuite
	public void init()
	{
		configDataProvider =new ConfigDataProvider("config");
	    excelDataProvider = new ExcelDataProvider("TestData");
	    
	    extentHtmlReporter = new ExtentHtmlReporter("./Reports/inetBanking_report_"+Helper.getCurrentDateTime()+".html");
	    extentHtmlReporter.config().setDocumentTitle("RT Automation Reports");
	    extentHtmlReporter.config().setReportName("RT Test");
//	    extentHtmlReporter.config().setTheme(Theme.STANDARD);
	    extentHtmlReporter.config().setTheme(Theme.DARK);
	    
	    extentReports = new ExtentReports();
	    extentReports.attachReporter(extentHtmlReporter);
	    
	    extentReports.setSystemInfo("Hostname", "Local Host");
	    extentReports.setSystemInfo("OS", "Window");
	    extentReports.setSystemInfo("Browser", "Chrome");
	    extentReports.setSystemInfo("TE", "Akash");
	    extentReports.setSystemInfo("Test Cases", "Smoke Test cases");
	    
	}
	
	
	
	@BeforeMethod
	@Parameters({"browsername"})
	public void setup(@Optional("Chrome") String brname)
	{

		if(brname.equals("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if (brname.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if (brname.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else
		{
			
			System.out.println("Expected browser isn't exist");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		
		
		driver.get(configDataProvider.getAppURL());
	}
	
	
	@AfterMethod
	public void teardown() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit();
	}
	
	@AfterTest
	public void extentFlush(ITestResult result) throws Exception
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
//			extentTest.fail("Test Case Failed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		extentReports.flush();
	}

}
