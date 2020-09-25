import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Testing {
	    String path="H:/Java/Eclipse/Workspace/SW/Drivers/chromedriver-85.exe";
	    WebDriver driver;	
	    String BaseUrl="https://dev.pbees.party/";
	    @BeforeTest()
	    public void setup(){
	    	System.setProperty("webdriver.chrome.silentOutput","true");
	    	System.setProperty("webdriver.chrome.driver",path);
			driver=new ChromeDriver();
			driver.get(BaseUrl);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	    }
	    
		@Test(priority=1)
		public void loginPage(){
			driver.findElement(By.partialLinkText("Sign Up/Log In")).click();
			WebElement page=driver.findElement(By.className("pb-auth-modal__content"));
			page.findElement(By.name("username")).sendKeys("arjun@yopmail.com");
			page.findElement(By.tagName("button")).click();
			page.findElement(By.name("password")).sendKeys("password");
			page.findElement(By.xpath("//button[(text()='Log In')]")).click();
			driver.findElement(By.xpath("//div[@title='Close']")).click();	
		}
		@Test(priority=2)
		public boolean test(){
			WebElement a=driver.findElement(By.className("pb-site-header__nav-secondary"));
			return a.isDisplayed();
		}
		
		//@Test(priority=2)
		public void titleValidation(){
			String Actual_Tilte=driver.getCurrentUrl();
			System.out.println(Actual_Tilte);
			String Expected_Title="StoryWeaver";
			Assert.assertEquals(Actual_Tilte, Expected_Title);
		}
		
		//@Test(priority=3)
		public void mouseOver() throws InterruptedException{
			Thread.sleep(15000);
			WebElement Element=driver.findElement(By.linkText("Fat King Thin Dog-23"));
			JavascriptExecutor js=(JavascriptExecutor)driver;
			 js.executeScript("arguments[0].scrollIntoView(true);",Element);
			 Thread.sleep(2000);
			 WebElement target=driver.findElement(By.xpath("//ul[@class='pb-list pb-list--inline']//li//div[@title='Delete']"));
			 Actions action=new Actions(driver);
			 action.moveToElement(target).click().perform();
//			Actions actions=new Actions(driver);
//			WebElement target=driver.findElement(By.xpath("//span[text()='Read']"));
//			actions.moveToElement(target).perform();
//			driver.findElement(By.xpath("//a[@href='/stories?sort=Ratings']")).click();
//			String a=driver.findElement(By.className("pb-book__title")).getText();
//			System.out.println(a);
			}
		
		//@Test(priority=4)
		public void dropdown() throws InterruptedException{
			List<WebElement> filters=driver.findElements(By.xpath("//ul[@class='pb-list pb-list--inline']/li"));
			System.out.println("No of Filters:"+filters.size()+"");
			System.out.println("Filters are: ");
			for(int i=0;i<filters.size();i++){
				Thread.sleep(2000);
				System.out.println(filters.get(i).getText());
				filters.get(i).click();
				/*filter_bar=driver.findElement(By.className("pb-filters-bar__action-wrapper"));
				filters=filter_bar.findElements(By.cssSelector("a"));
				filter_bar.findElement(By.className("pb-picklist__options"));
				List<WebElement> List=driver.findElements(By.className("pb-checkbox__label"));
				System.out.println(List.size());
				for(int j=0;j<List.size();j++){
					String a=List.get(j).getText();
					System.out.println(a);
					}*/
					
			}}
		
		//@AfterTest()
		public void close(){
		    driver.close();
		}
		}

	
	





	        




