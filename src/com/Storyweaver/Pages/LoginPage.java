package com.Storyweaver.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

	public class LoginPage extends BasePage{
		
		public LoginPage() {
			PageFactory.initElements(driver,this);
		}
		
		 @FindBy(className="pb-auth-modal__content") 
		  WebElement page;
		 @FindBy(name="username")
		  WebElement username;
		 @FindBy(xpath=("//button[@type='submit']"))
		  WebElement nextbutton;
		 @FindBy(name="password")
		  WebElement password;
		 @FindBy(xpath=("//button[(text()='Log In')]")) 
		  WebElement submit;
		 @FindBy(xpath="//div[@title='Close']")
		 WebElement Close;
		 @FindBy(className="pb-slim-notification__content-wrapper")
		 WebElement Notification;
		 @FindBy(xpath=("//div[@title='Close']")) 
		 WebElement login_successsful_notification;
		 
	public void Login_Page(String userid,String pass) throws InterruptedException{
    	  username.sendKeys(userid);
    	  nextbutton.click();
    	  password.sendKeys(pass);
    	  submit.click();
    	  Close.click();
    	  HomePage.wait(driver,Notification,5);
    	  login_successsful_notification.click();
    	 }
    	 }

