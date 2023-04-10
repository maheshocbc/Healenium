package Healenium.Tilda;


import com.epam.healenium.SelfHealingDriver;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class BaseTest extends Utilities {
    static public SelfHealingDriver driver;
//    public static WebDriver delegate;

   
     public static void setUp() throws Exception {
       WebDriverManager.chromedriver().setup();
    	// System.setProperty("webdriver.chrome.driver", "C:/estimate/chromedriver.exe"); 
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(false);
        //declare delegate
        //Config config = ConfigFactory.load("healenium.properties");
    	// Config config = ConfigFactory.systemProperties().withFallback(ConfigFactory.load("healenium.properties").withFallback(ConfigFactory.load()));
        WebDriver delegate = new ChromeDriver(options);
        driver = SelfHealingDriver.create(delegate);
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(1200, 800));
        driver.get("http://project4948150.tilda.ws");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        Thread.sleep(3500);
    }
    
  
//     public void start() throws InterruptedException {
//    	WebElement about=driver.findElement(By.xpath("//td[normalize-space()='About us']"));
//    	about.click();
//    	 Thread.sleep(3500);
//    	 System.out.println("About us");
//    	
//    }
//    
//    public void nextstep() throws InterruptedException {
//    	 Thread.sleep(3500);
//    	WebElement whatwedo=driver.findElement(By.xpath("//td[normalize-space()='What we do']"));
//    	whatwedo.click();
//    	System.out.println("whatwedo");
//    }

   
    static public void afterAll() {
        if (driver != null) {
           // driver.quit();
        }
    }

  @Attachment(value = "Screenshot", type = "image/png")
  public byte[] screenshot() {
      return ((TakesScreenshot) driver.getDelegate()).getScreenshotAs(OutputType.BYTES);
  }
}
