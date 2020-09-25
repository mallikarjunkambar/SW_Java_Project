import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class Parallel {

	
	String path="H:/Java/Eclipse/Drivers/Chrome New/chromedriver.exe";
    public WebDriver driver;
    String BaseUrl="https://dev.pbees.party";
    SoftAssert a=new SoftAssert();

	
	@Test()
	public void loginPage(){
		System.setProperty("webdriver.chrome.driver",path);
		driver=new ChromeDriver();
		driver.get(BaseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		/*driver.findElement(By.partialLinkText("Sign Up/Log In")).click();
		WebElement page=driver.findElement(By.className("pb-auth-modal__content"));
		page.findElement(By.name("username")).sendKeys("arjun@yopmail.com");
		page.findElement(By.tagName("button")).click();
		page.findElement(By.name("password")).sendKeys("password");
		page.findElement(By.xpath("//button[(text()='Log In')]")).click();*/}
	
	@Test()
	public void mtitleValidation(){
		String Actual_Tilte=driver.getTitle();
		System.out.println(Actual_Tilte);
		String Expected_Title="StoryWeaver";
		a.assertEquals(Actual_Tilte, Expected_Title);
		//Assert.assertEquals(Actual_Tilte, Expected_Title);
		System.out.println("Condition passed");
		}
	
	@Test()
	public void signIn(){
		driver.findElement(By.partialLinkText("Sign Up/Log In")).click();
	}
	
	
}
