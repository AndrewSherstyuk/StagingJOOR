
// A T T E N T I O N ! Before running this script, you should have the following file on your machine: C:\Users\IMG_1016.png. 
//The file should be larger than 4Mb

// A T T E N T I O N ! To successfully handle popups, please create the FF user. 
// Here's the guide https://support.mozilla.org/t5/Install-and-Update/Use-the-Profile-Manager-to-create-and-remove-Firefox-profiles/ta-p/2914


package automationFramework;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.TC_Base;


public class TC8_UploadTooLargeFilePng extends TC_Base {

	public static void main (String... args) throws InterruptedException {
		
		TC8_UploadTooLargeFilePng test = new TC8_UploadTooLargeFilePng();
		test.login();
		test.uploadTooLargeFilePngTest();
		test.logout();
		test.close();
	}		
	
	public void uploadTooLargeFilePngTest() throws InterruptedException {		
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
		driver.findElement(By.id("MessageAttachmentUpload")).sendKeys("C:\\Users\\IMG_1016.png");
		
		// Print a log message to the screen
		System.out.println("Successfully uploaded IMG_1016.png");
				
		//Send the message
		WebElement element4 = driver.findElement(By.xpath("//a[@class='button button-3 float_left j-form-ajax-submit']"));
		element4.click();
		Thread.sleep(12000);
				
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		// Print a log message to the screen
		System.out.println("ALERT CONFIRMED: 'File is too large'");
		
		// Click the cross button to close Compose a Message popup 					
		driver.findElement(By.xpath("//img[@alt='Close']")).click();
	}
}
