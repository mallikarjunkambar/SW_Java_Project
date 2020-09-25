package com.Storyweaver.Pages;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ReadPage extends BasePage{
	public ReadPage() {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy (xpath="//span[text()='Read']") 
	WebElement target;
	@FindBy(className="pb-dropdown__contents") 
	WebElement a; 
	@FindBy(xpath=("//a[@href='/stories?sort=Ratings']")) 
	WebElement Read;
	@FindBy(xpath=("//a[@href='/audios?isAudio=true&sort=Ratings&story_type=audio']")) 
	WebElement Readalong;
	@FindBy(xpath=("//a[@href='/lists']")) 
	WebElement Lists;
	@FindBys(@FindBy(xpath="//ul[@class='pb-list pb-list--inline']/li"))
	List<WebElement> filters;
	@FindBys(@FindBy(xpath="//div[@class='pb-picklist__options']/div"))
	List<WebElement> Dropdown_Options;
	@FindBy(id="filters-bar-sort-by")
	WebElement SortBy;
	@FindBys(@FindBy(xpath="//select[@id='filters-bar-sort-by']/option"))
	List<WebElement> SortBy_Options;
	@FindBy(className="pb-book__title")
	WebElement Story_Title;
	@FindBy(className="pb-book__wrapper")
	WebElement Story_Details_Page;
	@FindBy(className="pb-book-card__container")
	WebElement Story_Card;
	@FindBy(xpath="//div[@class='pb-floating-actions-bar__container']//a[text()='Read Story']")
	WebElement Read_Story;
	@FindBy(xpath="//div[@class='pb-floating-actions-bar__container']//a[text()='Readalong']")
	WebElement Readalong_Story;
	@FindBy(className="pb-audio-player")
	WebElement Audio_Player;
	@FindBy(className="pb-book-reader__page-ref")
	WebElement No_of_Pages;
	@FindBy(xpath="//div[@title='Next']")
	WebElement Next_Button;
	@FindBy(xpath="//span[@dir='ltr']//span[@class='pb-stat__value']")
	WebElement Read_Count;
	@FindBy(xpath="//a[text()='Next Story']")
	WebElement Smiley_Rating_Popup_Next_button;
	@FindBy(xpath="//div[@title='Close']")
	WebElement Next_Read_Suggestions_Popup;

	
	public void mouse_hover(String Page){
	 Actions actions=new Actions(driver);
	 actions.moveToElement(target).perform();
	 if (Page.equalsIgnoreCase("read")){
		 Read.click();
	 }
	 else if(Page.equalsIgnoreCase("readalong")){
		 Readalong.click();
	 }
	 else if(Page.equalsIgnoreCase("lists")){
		 Lists.click();
	 }}
	 
	 public boolean filters_count(){
		return filters.size()==5;
	 }
	 
	 public boolean is_Read_Page(){ 
			return driver.getCurrentUrl().
			equals("https://dev.pbees.party/stories?sort=Ratings");
		}
	 
	 public boolean is_Readalong_Page(){ 
			return driver.getCurrentUrl().
			equals("https://dev.pbees.party/audios?isAudio=true&sort=Ratings&story_type=audio");
		}
	 
	 public boolean filters() throws InterruptedException{
		 for(int i=0;i<filters.size();i++){
			 Thread.sleep(500);
			 //System.out.println(filters.get(i).getText());
			 filters.get(i).click();
			 for(int j=0;j<Dropdown_Options.size();j++){
				 //System.out.println(Dropdown_Options.get(j).getText());
				 Dropdown_Options.get(j).isDisplayed();
				 Dropdown_Options.get(j).isEnabled();}
			 Thread.sleep(500);
			 filters.get(i).click();
		}
		return true;
	  }
	 
	  public boolean Sort_By(){
		 SortBy.click();
		 return SortBy_Options.size()==5;
	  }
	 
	  public boolean SortBy_Options(){
		 for(int i=0;i<SortBy_Options.size();i++){
			 //System.out.println(SortBy_Options.get(i).getText());
			 SortBy_Options.get(i).isDisplayed();
		 }
		SortBy.click();
		return true;
	  }
	 
	  public String get_Story_Title(){
		return Story_Title.getText();
		
	 }
	 
	 public void select_First_Story_Card(){
		 Actions action=new Actions(driver);
		 action.moveToElement(Story_Card, 90,50).click().perform();
		 HomePage.wait(driver, Story_Details_Page,8);
	 }
	  
	 public boolean read_a_Story_and_Verify_Count(String Button) throws InterruptedException{
		 int Before_Read_count=Integer.parseInt(Read_Count.getText());
		 if(Button.equalsIgnoreCase("Read")){
			 Read_Story.click();}
		 else if(Button.equalsIgnoreCase("Readalong")){
			 Readalong_Story.click();
			 HomePage.wait(driver, Audio_Player,10);
			 Assert.assertTrue(Audio_Player.isDisplayed(),"Audio Player is missing");}
		 HomePage.wait(driver, Next_Button,10);
		 String Pages=No_of_Pages.getText();
		 String [] s=Pages.split("/ ");
		 int size=Integer.parseInt(s[1]);
		 for(int i=0;i<size;i++){
			 if(i!=size){
				 Next_Button.click();
				 Thread.sleep(500);}}
		 HomePage.wait(driver, Smiley_Rating_Popup_Next_button,15);
		 Smiley_Rating_Popup_Next_button.click();
		 HomePage.wait(driver,Next_Read_Suggestions_Popup,15);
		 Next_Read_Suggestions_Popup.click();
		 int After_Read_count=Integer.parseInt(Read_Count.getText());
		 if(After_Read_count==Before_Read_count+1){
			 return true;}
		 else{
			 return false;}
	 }
	 	 
}










