package com.Storyweaver.Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BasePage {
	 static WebDriver driver;
	 public static void BrowserLaunch(String browser,String URL){
		if(browser.equalsIgnoreCase("Firefox")){
			driver=new FirefoxDriver();
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/Drivers/geckodriver.exe");}
		else if(browser.equalsIgnoreCase("Chrome")){
			System.setProperty("webdriver.chrome.silentOutput","true");
			System.setProperty("webdriver.chrome.driver","H:/Java/Eclipse/Workspace/SW/Drivers/chromedriver-85.exe");
//			ChromeOptions options=new ChromeOptions();
//			options.addArguments("window-size=1400,800");
//			options.addArguments("headless");
			driver=new ChromeDriver();}
		driver.get(URL);	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		
		
}}
