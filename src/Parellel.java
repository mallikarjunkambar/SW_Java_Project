import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class Parellel {
	String path="H:/Java/Eclipse/Drivers/Chrome New/chromedriver.exe";
    WebDriver driver;	
    String BaseUrl="https://dev.pbees.party";
	
	@Test()
	public void loginPage(){
		System.setProperty("webdriver.chrome.driver",path);
		driver=new ChromeDriver();
		driver.get(BaseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.findElement(By.partialLinkText("Sign Up/Log In")).click();
		WebElement page=driver.findElement(By.className("pb-auth-modal__content"));
		page.findElement(By.name("username")).sendKeys("arjun@yopmail.com");
		page.findElement(By.tagName("button")).click();
		page.findElement(By.name("password")).sendKeys("password");
		page.findElement(By.xpath("//button[(text()='Log In')]")).click();}
	
	@Test()
	public void loginPage1(){
		System.setProperty("webdriver.chrome.driver",path);
		driver=new ChromeDriver();
		driver.get(BaseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.findElement(By.partialLinkText("Sign Up/Log In")).click();
		WebElement page=driver.findElement(By.className("pb-auth-modal__content"));
		page.findElement(By.name("username")).sendKeys("arjun@yopmail.com");
		page.findElement(By.tagName("button")).click();
		page.findElement(By.name("password")).sendKeys("password");
		page.findElement(By.xpath("//button[(text()='Log In')]")).click();}
	}
