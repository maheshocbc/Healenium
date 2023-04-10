package Healenium.Tilda;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.epam.healenium.SelfHealingDriver;

public class Utilities {
	
	public static  SelfHealingDriver getDriver() {
		return BaseTest.driver;
	}
	
	  public void start() throws InterruptedException {
	    	WebElement about=getDriver().findElement(By.xpath("//td[normalize-space()='About us']"));
	    	about.click();
	    	 Thread.sleep(3500);
	    	 System.out.println("About us");
	    	
	    }
	    
	    public void nextstep() throws InterruptedException {
	    	 Thread.sleep(3500);
	    	WebElement whatwedo=getDriver().findElement(By.xpath("//td[normalize-space()='What we do']"));
	    	whatwedo.click();
	    	System.out.println("whatwedo");
	    }
	
	
	

}
