package automationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TC2_SendMessageToOne {

	
	public static void main (String[] args) throws InterruptedException {
		
		// Create a new instance of the Firefox driver
		WebDriver driver;
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver-v0.14.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
				
		//Launch https://staging.joordev.com website
		driver.get("https://staging.joordev.com/");
		 
		// Print a log message to the screen
		System.out.println("Successfully opened https://staging.joordev.com/");
		 
		Thread.sleep(5);
		
		//Click on the Login button
		driver.findElement(By.className("login-button")).click();
		
		Thread.sleep(500);
		
		//Fill in the Login Name field		
		WebElement element = driver.findElement(By.id("login-name"));
		element.sendKeys("qatest1");
		
		//Fill in the Email field 
		WebElement element1 = driver.findElement(By.name("data[User][password]"));
		element1.sendKeys("qatest1");
		//and submit
		element1.sendKeys(Keys.RETURN);
		
		Thread.sleep(1000);
		
		// Print a log message to the screen
		System.out.println("Successfully logged in to https:	//staging.joordev.com/");
		
		//Open the Compose a Message popup (sorry for this trick: I couldn't find a way to click on the Message button to select Send Message)
		driver.get("https://staging.joordev.com/messages/#!compose");
		
		Thread.sleep(1000);
		
		//Make "SEND TO ALL MY CONNECTIONS" radio button
		WebElement radioBtn = driver.findElement(By.id("MessageSendToSelectConnections"));
		radioBtn.click();
		
		WebElement elementA = driver.findElement(By.name("recipient"));
		elementA.sendKeys("j");
				
		Thread.sleep(5000);
		//driver.findElement(By.xpath("/html/body/ul/li[1]/a")).click();
		
		driver.findElement(By.xpath("//a[contains(.,'JOOR Regress ( JR112 ) - New York, NY')]")).click();
		
		//driver.findElement(By.cssSelector(".ui-autocomplete:not([style*='display: none']) .ui-menu-item:nth-child(-1) a")).click();
		
		//driver.findElement(By.xpath("//ul[contains(@class,'ui-autocomplete')][not(contains(@style,'display: none'))]//li[contains(@class,'ui-menu-item')]/a[.='JOOR Regress ( JR112 ) - New York, NY']")).click();

			
		
		// Print a log message to the screen
		//System.out.println("Successfully selected SEND TO ALL MY CONNECTION radio button");
		
		//Fill in the Message Subject
		//WebElement element2 = driver.findElement(By.id("MessageSubject"));
		//element2.sendKeys("Test Message");
		
		// Print a log message to the screen
		//System.out.println("Successfully added the message subject");
		
		//Fill in the message Body
		//WebElement element3 = driver.findElement(By.id("MessageBody"));
		//element3.sendKeys("This is a message sent by a Selenium test script.\nPlease ignore and do NOT reply.\nThe message is Sent To All My Connections.");
		
		// Print a log message to the screen
		//System.out.println("Successfully added the message body");
				
		//Send the message
		//WebElement element4 = driver.findElement(By.xpath("//a[@class='button button-3 float_left j-form-ajax-submit']"));
		//element4.click();	
		
		// Print a log message to the screen
		//System.out.println("Successfully sent the message");
					
		//Thread.sleep(3000);
				
		// Close the driver
		//driver.quit();
		
		// Print a log message to the screen
		//System.out.println("The brower's closed");
	}
}
