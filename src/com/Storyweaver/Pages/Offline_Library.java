package com.Storyweaver.Pages;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class Offline_Library extends BasePage {
	
	public Offline_Library(){
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//a[text()='Read']")
	WebElement Read_Tab;
	@FindBy(xpath="//div[@title='Save to offline library']")
	WebElement Save_to_OL;
	@FindBy(xpath="//div[@title='Delete from offline library']")
	WebElement Delete_from_OL;
	@FindBys(@FindBy(xpath="//div[@class='pb-tab pb-tab--active']//h3[@class='pb-book-card__title']"))
	List<WebElement> Stories_in_offline_library;
	@FindBy(xpath="//a[text()='Manage Stories']")
	WebElement Click_ManageStory;
	@FindBy(xpath="//label[text()='Select to delete']")
	WebElement Select_Story_to_delete;
	@FindBy(xpath="//div[@title='Delete']")
	WebElement Delete_Story;
	@FindBy(xpath="//div[@class='pb-columnizer__column']/a[text()='Delete']")
	WebElement Delete_PopUp;
	@FindBy(className="pb-slim-notification__content")
	WebElement Notification;
	@FindBy(xpath="//div[@title='Close']")
	WebElement Close_Notification;
	
	
	public void read_Tab(){
		Read_Tab.click();
	 }
	
	 public void click_On_Save_to_OL(){
		 Save_to_OL.click();
		 HomePage.wait(driver,Delete_from_OL,20);
	 }
	 
	 public boolean Delete_from_OL_button(){
		 return Delete_from_OL.isDisplayed();
	 }
	
	public void delete_Story(){
		Click_ManageStory.click();
		Select_Story_to_delete.click();
		Delete_Story.click();
		Delete_PopUp.click();
	 }
	
	public boolean notification(){
		Notification.isDisplayed();
		Close_Notification.click();
		return true;
	 }
	
	public boolean verify_Story_in_offline_library(String Story_Name){
		int temp=0;
		for(int i=0;i<Stories_in_offline_library.size();i++){
		if(Stories_in_offline_library.get(i).getText().equals(Story_Name)){
			temp=temp+1;}}
			if(temp==1){
				return true;}
			else{
				return false;}
	 }
	
	}
	
	
	
	
	
	
	

