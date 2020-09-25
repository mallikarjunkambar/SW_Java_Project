package com.Storyweaver.Testcases;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.Storyweaver.Pages.BasePage;
import com.Storyweaver.Pages.Bookshelf;
import com.Storyweaver.Pages.CreatePage;
import com.Storyweaver.Pages.HomePage;
import com.Storyweaver.Pages.LoginPage;
import com.Storyweaver.Pages.Offline_Library;
import com.Storyweaver.Pages.ReadPage;

public class TestCases extends BasePage{
	String userid="arjun@yopmail.com";
	String pass="password";
	String browser="chrome";
	String BaseURL="https://dev.pbees.party/";
	
	HomePage homepage;
	LoginPage loginpage;
	ReadPage readpage;
	Bookshelf bookshelf;
	Offline_Library offline_lib;
	CreatePage createpage;
	SoftAssert soft=new SoftAssert();
	 
    @BeforeTest
	public void setUp(){
		BasePage.BrowserLaunch(browser, BaseURL);
		}
    
//Home Page    
    @Test(priority=1)
    public void home_Page(){
    	homepage=new HomePage();
    	soft.assertTrue(homepage.is_Home_Page(BaseURL),"Not Home page");
    	soft.assertTrue(homepage.is_Guest_User(),"Not Guest user");
    	soft.assertAll();
    }
    
//Login Page
    @Test(priority=2)
    public void login_Page() throws InterruptedException{
    	homepage=new HomePage();
    	homepage.sign_In();
    	loginpage=new LoginPage();
    	loginpage.Login_Page(userid, pass);
    	soft.assertFalse(homepage.is_Guest_User());
    	soft.assertAll();
    }

//Read Page
    @Test(priority=3)
    public void read_Page() throws InterruptedException{
    	homepage=new HomePage();
    	readpage=new ReadPage();
    	readpage.mouse_hover("read");
    	soft.assertTrue(readpage.is_Read_Page(),"Not Readpage");
    	soft.assertTrue(readpage.filters_count(), 
    			"filter count is not equal to 5");
    	//soft.assertTrue(readpage.filters());
    	soft.assertTrue(readpage.Sort_By(),
    			"Sort By options count is not equal to 5");
    	soft.assertTrue(readpage.SortBy_Options());
    	readpage.select_First_Story_Card();
    	HomePage.scroll_Down(300);
    	//soft.assertTrue(readpage.read_a_Story_and_Verify_Count("Read"),
    	//		"Read count is not getting increased");
    	soft.assertAll();
    }
    
//Add to My Bookshelf
    @Test(priority=4)
    public void add_to_My_Bookshelf() throws InterruptedException{
    	homepage=new HomePage();
    	bookshelf=new Bookshelf();
        String Title=readpage.get_Story_Title();
        Thread.sleep(1000);
    	bookshelf.click_On_Add_to_My_Bookshelf();
    	if(homepage.is_Guest_User()==true){
    		soft.assertTrue(bookshelf.login_Popup());}
    	soft.assertTrue(bookshelf.Delete_Bookshelf_Button(),
    			Title+ " story is not saved to Bookshelf");
    	soft.assertTrue(bookshelf.Display_Notification(),
    			"Story saved to Bookshelf notification is not displaying");
    	bookshelf.Notification_Close_Button();
    	homepage.Bookshelf_Page();
    	soft.assertTrue(bookshelf.verify_Story_in_Bookshelf_Lists(Title),
    			Title+ " story is not displaying in Bookshelf page");
    	bookshelf.delete_Story_from_Bookshelf_Lists(Title);
    	Thread.sleep(1000);
    	soft.assertFalse(bookshelf.verify_Story_in_Bookshelf_Lists(Title),
    			Title+ " story is not deleted from Bookshelf");
    	soft.assertAll();
    }
       	
//Save to Offline Library
    @Test(priority=5)
    public void save_to_OL() throws InterruptedException{
    	homepage=new HomePage();
    	offline_lib=new Offline_Library();
    	readpage.mouse_hover("read");
    	readpage.select_First_Story_Card();
    	String Title=readpage.get_Story_Title();
    	HomePage.scroll_Down(500);
    	offline_lib.click_On_Save_to_OL();
    	if(homepage.is_Guest_User()==true){
    		Assert.assertTrue(bookshelf.login_Popup());}
    	soft.assertTrue(offline_lib.Delete_from_OL_button(),
    			Title+ " story is not saved to OL");
    	soft.assertTrue(bookshelf.Display_Notification(),
    			" story saved to OL notification is not displaying");
    	bookshelf.Notification_Close_Button();
    	homepage.Offline_Library();
    	HomePage.scroll_Down(300);
    	offline_lib.read_Tab();
    	soft.assertTrue(offline_lib.verify_Story_in_offline_library(Title),
    			Title+ " story is not displaying in OL");
    	Thread.sleep(2000);
    	soft.assertTrue(offline_lib.notification());
    	offline_lib.delete_Story();
    	Thread.sleep(1000);
    	soft.assertFalse(offline_lib.verify_Story_in_offline_library(Title),
    			Title+ " story is not deleted from OL");
    	soft.assertAll();
    }
    
//Readalong Page
    @Test(priority=6)
    public void readalong_Page() throws InterruptedException{
    	homepage=new HomePage();
    	readpage=new ReadPage();
    	readpage.mouse_hover("readalong");
    	soft.assertTrue(readpage.is_Readalong_Page(),"Not Readalong Page");
    	soft.assertTrue(readpage.filters_count(), 
    			"filter count is not equal to 5");
    	soft.assertTrue(readpage.filters());
    	soft.assertTrue(readpage.Sort_By(),
    			"Sort By options count is not equal to 5");
    	soft.assertTrue(readpage.SortBy_Options());
    	readpage.select_First_Story_Card();
    	HomePage.scroll_Down(300);
    	soft.assertTrue(readpage.read_a_Story_and_Verify_Count("Readalong"),
    			"Read count is not getting increased");
    	soft.assertAll();
     }

//Create Page
    @Test(priority=7)
    public void create_Page() throws InterruptedException{
    	createpage=new CreatePage();
    	homepage.create_Page();
    	if(homepage.is_Guest_User()==true){
    		Assert.assertTrue(createpage.login_Popup(),"Login Popup is not coming up");
    		System.out.println("Login to SW");}
    	soft.assertTrue(createpage.verify_Create_Book_Page(),
    			"Create New Book Popup is not coming up");
    	String Langauge="English";
    	String Level="level 1:";
    	String Orientation="vertical";
    	createpage.enter_Book_Details(Langauge, Level, Orientation);
    	createpage.add_Image_to_Page();
    	soft.assertFalse(createpage.is_Image_Added_to_Page(),"Image is not added to page");
    	soft.assertTrue(createpage.verify_Image_Drawer(),"Image Drawer is not displaying");
    	createpage.add_Image_to_Page();
    	String Title=createpage.get_Title();
    	createpage.Publish_a_Story(Langauge);
    	soft.assertTrue(createpage.is_Notification_Displayed(),"Publish story notification "
   			+ "is not getting displayed");
    	createpage.verify_Published_Story_in_NewArrivals(Title);
    	soft.assertAll();
    }

    @AfterSuite
    public void teardown(){
    	homepage.sing_Out();
    	soft.assertTrue(homepage.is_Guest_User(),"Not Guest user");
    }
 }
	

	
		

