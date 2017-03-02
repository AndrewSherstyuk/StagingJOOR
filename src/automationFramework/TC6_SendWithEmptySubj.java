
// A T T E N T I O N ! To successfully handle popups, please create the FF user. 
// Here's the guide https://support.mozilla.org/t5/Install-and-Update/Use-the-Profile-Manager-to-create-and-remove-Firefox-profiles/ta-p/2914

package automationFramework;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.TC_Base;

public class TC6_SendWithEmptySubj extends TC_Base {

	public static void main(String[] args) throws InterruptedException {

		TC6_SendWithEmptySubj test = new TC6_SendWithEmptySubj();
		test.login();
		test.sendWithEmptySubjTest();
		test.logout();
		test.close();
	}

	public void sendWithEmptySubjTest() throws InterruptedException {		
		// Open the Compose a Message popup
		driver.get("https://staging.joordev.com/messages/#!compose");
		Thread.sleep(1000);

		// Make "SEND TO ALL MY CONNECTIONS" radio button
		WebElement radioBtn = driver.findElement(By.id("MessageSendToAllConnections"));
		radioBtn.click();

		// Print a Log In message to the screen
		System.out.println("Successfully selected SEND TO ALL MY CONNECTION radio button");

		// Don't fill in the Subject field

		WebElement element3 = driver.findElement(By.id("MessageBody"));
		element3.sendKeys("This is a message sent by a Selenium test script.\nPlease ignore and do NOT reply.\nThe message is Sent To All My Connections.");

		// Print a Log In message to the screen
		System.out.println("Successfully added the message body");

		// Send the message
		WebElement element4 = driver.findElement(By.xpath("//a[@class='button button-3 float_left j-form-ajax-submit']"));
		element4.click();
		Thread.sleep(2000);

		// Print a log message to the screen
		System.out.println("Clicked on the Send button");

		Alert alert = driver.switchTo().alert();
		alert.accept();

		// Print a Log message to the screen
		System.out.println("ALERT CONFIRMED: Your message could not be sent. Please ensure the message Subject and Body are not empty");
		Thread.sleep(500);
		
		// Click the cross button to close Compose a Message popup
		driver.findElement(By.xpath("//img[@alt='Close']")).click();
	}
}
