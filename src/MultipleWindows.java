import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class MultipleWindows {
	private String BaseUrl="https://chandanachaitanya.github.io/selenium-practice-site/?languages=Java&enterText=";
	private WebDriver driver=null;
	private String path="H:/Java/Eclipse/Drivers/Chrome New/chromedriver.exe";
	@BeforeTest
	public void setUp(){
		System.setProperty("webdriver.chrome.driver", path);
		driver=new ChromeDriver();
		driver.get(BaseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		}

	@Test
	public void multipleWindow() throws InterruptedException{
		String a=driver.getTitle();
		System.out.println(a);
		String ParentWindow=driver.getWindowHandle();
		driver.findElement(By.linkText("Lakshmi Chandana")).click();
		Set<String> WindowHandles=driver.getWindowHandles();
		for(String handle:WindowHandles){
			driver.switchTo().window(handle);
			System.out.println("Child window1: "+driver.getTitle()+"");
			Thread.sleep(2000);}
		driver.findElement(By.linkText("My Portfolio")).click();
		driver.switchTo().window(ParentWindow);
		System.out.println("Parent window: "+driver.getTitle()+"");
	}
}
