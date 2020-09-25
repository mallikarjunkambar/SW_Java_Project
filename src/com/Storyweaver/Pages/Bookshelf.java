package com.Storyweaver.Pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class Bookshelf extends BasePage{

	public Bookshelf(){
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(className="pb-dropdown__contents")
	WebElement login_Popup;
	@FindBy(xpath="//div[@title='Add to my bookshelf']")
	WebElement Add_to_My_Bookshelf;
	@FindBy(xpath="//div[@title='Delete from my bookshelf']")
	WebElement Delete_Bookshelf;
	@FindBy(className="pb-reading-list-entry__title")
	WebElement Story_Card_in_Bookshelf_Lists;
	@FindBy(className="pb-slim-notification__content-wrapper")
	WebElement Notification;
	@FindBy(xpath="//div[@title='Close']")                                                                                     
	WebElement Close_button;
	@FindBy(className="pb-reading-list__books")
	WebElement Bookshelf_Page;
	@FindBys(@FindBy(xpath="//h3[@class='pb-book-card__title']"))
	List<WebElement> Stories_in_bookshelf;
	@FindBy(className="pb-action-bar__section")
	WebElement Footer_Bar;
	@FindBy(xpath="//div[@title='Pen']")
	WebElement Edit_button;
	@FindBys(@FindBy(xpath="//div[@title='Delete']"))
	List<WebElement> Delete_Story_from_Bookshelf;
	@FindBy(xpath="//a[text()='Yes']")
	WebElement Delete_Story_Popup;
	@FindBy(xpath="//a[text()='Save changes']")
	WebElement Save_Button;
	
	
	public boolean login_Popup(){
		 return login_Popup.isDisplayed();
	 }
	
	 public void click_On_Add_to_My_Bookshelf(){
		 Add_to_My_Bookshelf.click();
		 HomePage.wait(driver,Delete_Bookshelf,5);
	 }
	 
	 public boolean Delete_Bookshelf_Button(){
		 return Delete_Bookshelf.isDisplayed();
	 }
	 
	 public boolean Display_Notification(){
		 return Notification.isDisplayed();
	 }
	 
	 public void Notification_Close_Button(){
		 Close_button.click();
	 }
	
	public boolean verify_Story_in_Bookshelf_Lists(String Story_Name){
		HomePage.wait(driver, Bookshelf_Page,8);
		int temp=0;
		for(int i=0;i<Stories_in_bookshelf.size();i++){
			if (Stories_in_bookshelf.get(i).getText().equals(Story_Name)){
				temp=temp+1;}}
		     if(temp==1){
			   return true;}
	         else{
				return false;}
		}
	 
	 public void delete_Story_from_Bookshelf_Lists(String Story_name) throws InterruptedException{
		 Edit_button.click();
		 int count=Delete_Story_from_Bookshelf.size();
		 WebElement Element=driver.findElement(By.partialLinkText(Story_name));
		 HomePage.scroll_Into_View(Element);
		 Thread.sleep(1000);
		 for(int i=0;i<count;i++){
			 if(i==count-1){
			 Delete_Story_from_Bookshelf.get(i).click();}}
		 Delete_Story_Popup.click();
		 Save_Button.click();
	 }
}
