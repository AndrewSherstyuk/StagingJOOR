
// A T T E N T I O N ! Before running this script, you should have the following file on your machine: C:\Users\13tvn113.pdf. 

// A T T E N T I O N ! To successfully handle popups, please create the FF user. 
// Here's the guide https://support.mozilla.org/t5/Install-and-Update/Use-the-Profile-Manager-to-create-and-remove-Firefox-profiles/ta-p/2914

package automationFramework;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TC7_UploadWrongExtFile {

	public static void main (String[] args) throws InterruptedException {
		
		
//  L  O  G  I  N
		
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
		System.out.println("Successfully logged in to https://staging.joordev.com/");
		
//  L  O  G  I  N
		
		
//  H A N D L I N G   ' C O M P O S E   A   M E S S A G E '  P O P U P
		
		//Open the Compose a Message popup 
		driver.get("https://staging.joordev.com/messages/#!compose");
		Thread.sleep(1000);		
		
		//Make "SEND TO ALL MY CONNECTIONS" radio button
		WebElement radioBtn = driver.findElement(By.id("MessageSendToAllConnections"));
		radioBtn.click();
		
		// Print a log message to the screen
		System.out.println("Successfully selected SEND TO ALL MY CONNECTION radio button");
		
		//Fill in the Message Subject
		WebElement element2 = driver.findElement(By.id("MessageSubject"));
		element2.sendKeys("Test Message");
		
		// Print a log message to the screen
		System.out.println("Successfully added the message subject");
		
		//Fill in the message Body
		WebElement element3 = driver.findElement(By.id("MessageBody"));
		element3.sendKeys("This is a message sent by a Selenium test script.\nPlease ignore and do NOT reply.\nThe message is Sent To All My Connections.");
		
		// Print a log message to the screen
		System.out.println("Successfully added the message body");
		
		//Adding a .jpg file of 4Mb of smaller
		driver.findElement(By.id("MessageAttachmentUpload")).sendKeys("C:\\Users\\13tvn113.pdf");
		
		// Print a log message to the screen
		System.out.println("Successfully uploaded 13tvn113.pdf");
				
		//Send the message
		WebElement element4 = driver.findElement(By.xpath("//a[@class='button button-3 float_left j-form-ajax-submit']"));
		element4.click();
		Thread.sleep(5000);
				
		// Confirming the alert message
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		// Print a log message to the screen
		System.out.println("ALERT CONFIRMED: File is too large");
		Thread.sleep(1000);
							
		// Close 'Compose a Message' popup
		driver.findElement(By.xpath("//img[@alt='Close']")).click();
				
//  H A N D L I N G   ' C O M P O S E   A   M E S S A G E '  P O P U P
				
		
//  L O G O U T
		
		// Click on Regress Java button
		driver.findElement(By.xpath("//span[contains(.,'Regress Java')]")).click();
		Thread.sleep(3000);
		
		// Click on Logout button
		driver.findElement(By.xpath("//a[@href='/users/logout']")).click();
		
		// Print a log message to the screen
		System.out.println("Successfully logged out");		
		Thread.sleep(2000);
		
//  L O G O U T
		
				
		// Close the driver
		driver.quit();
		
		// Print a log message to the screen
		System.out.println("The brower's closed");
	}
}
