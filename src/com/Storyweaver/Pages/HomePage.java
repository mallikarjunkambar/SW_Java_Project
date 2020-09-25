package com.Storyweaver.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
	
	public HomePage() {
		PageFactory.initElements(driver,this);
	}
	@FindBy(className="pb-site-nav-link__title")
	 WebElement SignIn;
	@FindBy(xpath="//a[text()='Sign Out']")
	WebElement SignOut;
	@FindBy (xpath="//span[text()='Read']") 
	 WebElement target;
	@FindBy(xpath=("//a[@href='/stories?sort=Relevance']")) 
	 WebElement Read;
	@FindBy(xpath=("//a[@href='/audios?isAudio=true&sort=Relevance&story_type=audio']")) 
	 WebElement Readalong;
	@FindBy(xpath=("//a[@href='/lists']")) 
	 WebElement Lists;
	@FindBy(className="pb-modal__content") 
	WebElement login_popup;
	@FindBy(xpath="//div[@class='pb-site-footer-notice']")
	WebElement Footer_Notice;
	@FindBy(xpath="//a[text()='Agree']")
	WebElement Agree_Button;
	@FindBy(xpath="//a[text()='Profile']")
	WebElement Profile;
	@FindBy(partialLinkText="My Bookshelf")
	WebElement MyBookshelf;
	@FindBy(className="pb-reading-list-card")
	WebElement Bookshelf_List;
        @FindBy(xpath="//div[@title='Offline Library']")
        WebElement Offline_Library;
        @FindBy(xpath="//span[text()='Create']")
	WebElement Create_Button;
	
	public boolean is_Home_Page(String BaseURL){ 
		return driver.getCurrentUrl().equals(BaseURL);
	}
	
	public boolean is_Guest_User(){
		String text=SignIn.getText();
		return (text.equals("Sign Up/Log In") && Footer_Notice.isDisplayed());
		}
	
	public void sign_In(){
		SignIn.click();
	    }
	
	public static void scroll_Down(int Vertical_Pexel){
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,"+Vertical_Pexel+")");
	}
	
	public static void scroll_Into_View(WebElement Element){
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",Element);
	}
	
	public void sing_Out(){
		SignIn.click();
		SignOut.click();
	    }
	
	public void agree_Button(){
		Agree_Button.click();
		}
	
	public static void wait(WebDriver driver, WebElement Element, int time_in_seconds){
		WebDriverWait wait=new WebDriverWait(driver, time_in_seconds);
		wait.until(ExpectedConditions.visibilityOf(Element));
	    }
	
	public static void wait_clickable(WebDriver driver, WebElement Element, int time_in_seconds){
		WebDriverWait wait=new WebDriverWait(driver, time_in_seconds);
		wait.until(ExpectedConditions.elementToBeClickable(Element));
	    }
	
	public void Bookshelf_Page() throws InterruptedException{
		SignIn.click();
		Profile.click();
		MyBookshelf.click();
		Bookshelf_List.click();
		}
	
	public void Offline_Library(){
		Offline_Library.click();
	    }
	
	public void create_Page(){
		Create_Button.click();
	    }

	public static void mouse_Hover(WebElement target){
		Actions actions=new Actions(driver);
		actions.moveToElement(target).perform();
	   }
	
	
	
	
}
