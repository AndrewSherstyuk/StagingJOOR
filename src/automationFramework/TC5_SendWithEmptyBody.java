
// A T T E N T I O N ! To successfully handle popups, please create the FF user. 
// Here's the guide https://support.mozilla.org/t5/Install-and-Update/Use-the-Profile-Manager-to-create-and-remove-Firefox-profiles/ta-p/2914

package automationFramework;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.TC_Base;

public class TC5_SendWithEmptyBody extends TC_Base {

	public static void main(String... args) throws InterruptedException {
		
		TC5_SendWithEmptyBody test = new TC5_SendWithEmptyBody();
		test.login();
		test.sendWithEmptyBodyTest();
		test.logout();
		test.close();		
	}

	public void sendWithEmptyBodyTest() throws InterruptedException {		
		// Open the Compose a Message popup (sorry for this trick: I couldn't
		// find a way to click on the Message button to select Send Message)
		driver.get("https://staging.joordev.com/messages/#!compose");

		Thread.sleep(1000);

		// Make "SEND TO ALL MY CONNECTIONS" radio button
		WebElement radioBtn = driver.findElement(By.id("MessageSendToAllConnections"));
		radioBtn.click();

		// Print a log message to the screen
		System.out.println("Successfully selected SEND TO ALL MY CONNECTION radio button");

		// Fill in the Message Subject
		WebElement element2 = driver.findElement(By.id("MessageSubject"));
		element2.sendKeys("Test Message");

		// Print a log message to the screen
		System.out.println("Successfully added the message subject");

		// Don't fill in the Body field

		// Send the message
		WebElement element4 = driver.findElement(By.xpath("//a[@class='button button-3 float_left j-form-ajax-submit']"));
		element4.click();
		Thread.sleep(2000);

		Alert alert = driver.switchTo().alert();
		alert.accept();

		// Print a log message to the screen
		System.out.println("ALERT CONFIRMED: Your message could not be sent. Please ensure the message Subject and Body are not empty");
		Thread.sleep(500);
		
		// Click the cross button to close Compose a Message popup
		driver.findElement(By.xpath("//img[@alt='Close']")).click();
	}
}
