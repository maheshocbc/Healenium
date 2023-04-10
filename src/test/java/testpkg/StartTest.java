package testpkg;




import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import Healenium.Tilda.BaseTest;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.epam.healenium.SelfHealingDriver;

import java.util.concurrent.TimeUnit;

public class StartTest{
	private SelfHealingDriver driver;
	
	@BeforeTest
	public void init() throws Exception  {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.setHeadless(false);
		WebDriver delegate = new ChromeDriver(options);
		driver=SelfHealingDriver.create(delegate);

		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.manage().window().setSize(new Dimension(1200, 800));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://4948150.tilda.ws");
		
	}
	
//	@Test (priority = 1)
//	public void Step1() throws InterruptedException {
//		b.start();
//	}
//

	@Test (priority = 2)
	public void Step2() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Thread.sleep(3500);
		JavascriptExecutor executor=(JavascriptExecutor) driver;
		executor.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(3500);
		WebElement about=driver.findElement(By.xpath("//td[contains(text(),'go')]"));
		about.click();
		Thread.sleep(2500);
		System.out.println("go");
		executor.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(2500);
		WebElement ss=driver.findElement(By.xpath("//span[contains(text(),'just')]"));
		ss.click();
		System.out.println("Lets go");
		executor.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(2500);
		WebElement whatwedo=driver.findElement(By.xpath("(//div[@class='t-btnwrapper t182__btnwrapper']//td)[2]"));
		whatwedo.click();
		System.out.println("See");


	}
	
	@AfterTest
	public void teardown() {
		System.out.println("hi");
	}

}
