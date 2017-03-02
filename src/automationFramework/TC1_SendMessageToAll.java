package automationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.TC_Base;

public class TC1_SendMessageToAll extends TC_Base {

	public static void main (String[] args) throws InterruptedException {
		
		TC1_SendMessageToAll test = new TC1_SendMessageToAll();
		test.login();
		test.sendMessageToAllTest();
		test.logout();
		test.close();
		
	}
	
	
	public void sendMessageToAllTest() throws InterruptedException {
		
		//Open the Compose a Message popup (sorry for this trick: I couldn't find a way to click on the Message button to select Send Message)
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
				
		//Send the message
		WebElement element4 = driver.findElement(By.xpath("//a[@class='button button-3 float_left j-form-ajax-submit']"));
		element4.click();	
		
		// Print a log message to the screen
		System.out.println("Successfully sent the message");
				
	}

	
}
