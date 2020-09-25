package com.Storyweaver.Pages;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class CreatePage extends BasePage {
	public CreatePage(){
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(className="pb-modal__bounds")
	WebElement Login_Popup;
	@FindBy(xpath="//div[@class='modal-body modal-body-app']/div[@class='form-disabled']")
	WebElement Create_Book_Popup;
	@FindBy(id="story_language_id")
	WebElement Select_Langauge;
	@FindBys(@FindBy(xpath="//select[@id='story_language_id']//option"))
	List<WebElement> Langauges_List;
	@FindBy(name="story[title]")
	WebElement Book_Title;
	@FindBy(id="varnam_ime_suggestions")
	WebElement Varnam_list;
	@FindBy(className="varnam_selected")
	WebElement Suggestion;
	@FindBys(@FindBy(xpath="//div[@class='control-group radio_buttons "
			+ "required story_reading_level']//strong"))
	List<WebElement> Reading_Level;
	@FindBys(@FindBy(xpath="//div[@class='control-group radio_buttons "
			+ "required story_orientation']//strong"))
	List<WebElement> Book_Orientation;
	@FindBy(xpath="//input[@value='start with images']")
	WebElement Start_with_images_Button;
	@FindBy(className="image-drawer-content")
	WebElement Image_Drawer;
	@FindBy(className="add-btn-overlay")
	WebElement Editor;
	@FindBy(className="illustration_drawer_img")
	WebElement Select_Image;
	@FindBy(xpath="//div[@class='img-card-action-block dead-center']"
			+ "/div[text()='add to current page']")
	WebElement Add_to_Page;
	@FindBy(css="i[class='cropControlSave']")
	WebElement Save_Image;
	@FindBy(xpath="//div[@class='page-list']//div[@class='covers']")
	WebElement Select_front_Cover_Page;
	@FindBy(xpath="//span[text()='add an image']")
	WebElement Add_Image;
	@FindBy(xpath="//a[@title='Your story will go live now']")
	WebElement Publish_Button_in_Editor;
	@FindBy(id="storycard-img-edit-done")
	WebElement Done_Button;
	@FindBy(id="publish-book") 
	WebElement Publish_Button;
	@FindBy(xpath="//h3[@class='pb-book-card__title']")
	WebElement Story_Title;
	@FindBy(id="story_english_title") 
	WebElement English_Title;
	@FindBy(id="story_synopsis") 
	WebElement Synopsis;
	@FindBy(xpath="//button[text()='next']") 
	WebElement Next_Button;
	@FindBy(xpath="//button[text()='publish']") 
	WebElement Publish_Story;
	@FindBy(xpath="//button[@data-toggle='dropdown']") 
	WebElement Category_Dropdown;
	@FindBy(xpath="//label[@class='checkbox']") 
	WebElement Select_Options_in_Dropdown;
	@FindBy(className="pb-slim-notification__content-wrapper") 
	WebElement Notification;
	@FindBy(xpath="//div[@title='Close']") 
	WebElement Close_Notification;
	@FindBy(partialLinkText="New Arrivals") 
	WebElement New_Arrivals;
	@FindBy(xpath="//div[@class='pb-tab pb-tab--active']//h3[@class='pb-book-card__title']")
	WebElement Verify_Title;
	
	public boolean verify_Create_Book_Page(){
		HomePage.wait(driver, Create_Book_Popup,5);
		return Create_Book_Popup.isDisplayed();
	}
	
	public boolean login_Popup(){
		return Login_Popup.isDisplayed();
	}
	
	public void enter_Book_Details(String Langauge,String Level,String Orientation) 
			throws InterruptedException{
		Select_Langauge.click();
		for(int i=0;i<Langauges_List.size();i++){
			if(Langauges_List.get(i).getText().equalsIgnoreCase(Langauge)){
				Langauges_List.get(i).click();
				break;}}
		Select_Langauge.click();
		Book_Title.sendKeys(Langauge);
		try{
			Thread.sleep(1500);
			Suggestion.click();
		}
		catch(Exception e){	
			System.out.println("Vernam/Quillpad text is not "
					+ "available for the langauge: "+Langauge);
		}
		for(int i=0;i<Reading_Level.size();i++){
			if(Reading_Level.get(i).getText().equalsIgnoreCase(Level)){
				Reading_Level.get(i).click();}}
		for(int i=0;i<Book_Orientation.size();i++){
			if(Book_Orientation.get(i).getText().equalsIgnoreCase(Orientation)){
				Book_Orientation.get(i).click();}}
		Start_with_images_Button.click();
	}
			
	public void add_Image_to_Page(){
		HomePage.wait(driver,Select_Image,10);
		HomePage.mouse_Hover(Select_Image);
	    Add_to_Page.click();
	    Save_Image.click();
	}
	
	public boolean is_Image_Added_to_Page(){
		HomePage.wait_clickable(driver, Select_front_Cover_Page,5);
		try {
			return Add_Image.isDisplayed();}
		catch(Exception e){
			return false;}
	}
	
	public boolean verify_Image_Drawer() throws InterruptedException{
		HomePage.wait_clickable(driver, Select_front_Cover_Page,5);
		Select_front_Cover_Page.click();
		Add_Image.click();
		HomePage.wait(driver,Image_Drawer,5);
		return Image_Drawer.isDisplayed();
	}
	
	public void enter_Publish_Form(String Langauge) throws InterruptedException{
		Synopsis.sendKeys("synopsis");
		try{
			Thread.sleep(1500);
			Suggestion.click();}
		catch(Exception e){	
			System.out.println("Vernam/Quillpad text is "
					+ "not available for the langauge: "+Langauge+ "in Synopsis");}
		Category_Dropdown.click();
		Select_Options_in_Dropdown.click();
	}
	
	public String get_Title() throws InterruptedException{
		Thread.sleep(4000);
		Publish_Button_in_Editor.click();
		HomePage.wait_clickable(driver,Done_Button,5);
		Done_Button.click();
		HomePage.wait(driver,Story_Title,5);
		return Story_Title.getText();
	}
	
	public void Publish_a_Story(String Langauge) throws InterruptedException{
		HomePage.wait_clickable(driver,Publish_Button,5);
		Publish_Button.click();
		if(!Langauge.equalsIgnoreCase("English")){
			English_Title.sendKeys(Langauge);
			enter_Publish_Form(Langauge);}
		else{
			enter_Publish_Form(Langauge);}
		HomePage.wait_clickable(driver,Next_Button,5);
		Next_Button.click();
		Publish_Story.click();
		}
	
	public boolean is_Notification_Displayed(){
		HomePage.wait(driver,Notification,30);
		return Notification.isDisplayed();
	}
	
	public void verify_Published_Story_in_NewArrivals(String Title){
		Close_Notification.click();
		driver.navigate().refresh();
		driver.navigate().refresh();
		HomePage.scroll_Down(1200);
		New_Arrivals.click();
		if(Verify_Title.getText().equalsIgnoreCase(Title)){
			System.out.println("Published story: "+Title+" is available in New Arrivals");
		}	
		else{
			System.out.println("Taking time to display the "
					+ "published story: "+Title+" in New Arrivals.");
		}
	}
}
	
	
	
	
	
	
	
	
	
	

























