package com.inetbanking.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;


public class ConfigDataProvider {
	
	
	Properties prop;
	
	public ConfigDataProvider(String configFileName)
	{
		try {
		    File fs= new File("./Config/" +configFileName+ ".properties");
		    FileInputStream fins =new FileInputStream (fs);
		    prop = new Properties();
		    prop.load (fins);		    
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	public String searchKey(String Keyname)
	{
	    return prop.getProperty(Keyname);
	}
	public String getUsername()
	{
		return prop.getProperty("Username");
	}
	public String getPassword()
	{
		return prop.getProperty("Password");
	}
	public String getAppURL()
	{
		return prop.getProperty("appURL");
	}
	
//	public static void main(String[]args) {
		
//		ConfigDataProvider config = new ConfigDataProvider("Config");
		
//		String appURL =config.searchKey("appURL");
		
//		System.out.println(appURL);
		
//		System.out.println(config.searchKey("Username"));
//		System.out.println(config.searchKey("Password"));
//	}

}
