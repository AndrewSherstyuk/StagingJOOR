package automationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.TC_Base;

public class TC2_SendMessageToOne extends TC_Base {

	public static void main(String... args) throws InterruptedException {

		TC2_SendMessageToOne test = new TC2_SendMessageToOne();
		test.login();
		test.sendMessageToOneTest();
		test.logout();
		test.close();

	}

	public void sendMessageToOneTest() throws InterruptedException {

		// Open the Compose a Message popup (sorry for this trick: I couldn't
		// find a way to click on the Message button to select Send Message)
		driver.get("https://staging.joordev.com/messages/#!compose");

		Thread.sleep(1000);

		// Make "SEND TO ALL MY CONNECTIONS" radio button
		WebElement radioBtn = driver.findElement(By.id("MessageSendToSelectConnections"));
		radioBtn.click();

		WebElement elementA = driver.findElement(By.name("recipient"));
		elementA.sendKeys("j");

		Thread.sleep(5000);
		// driver.findElement(By.xpath("/html/body/ul/li[1]/a")).click();

		WebElement elementM = driver.findElement(By.xpath("//a[contains(.,'JOOR Regress ( JR112 ) - New York, NY')]"));
		elementM.findElement(By.xpath("..")).click();

		// driver.findElement(By.cssSelector(".ui-autocomplete:not([style*='display:
		// none']) .ui-menu-item:nth-child(-1) a")).click();

		// driver.findElement(By.xpath("//ul[contains(@class,'ui-autocomplete')][not(contains(@style,'display:
		// none'))]//li[contains(@class,'ui-menu-item')]/a[.='JOOR Regress (
		// JR112 ) - New York, NY']")).click();

		// Print a log message to the screen
		// System.out.println("Successfully selected SEND TO ALL MY CONNECTION
		// radio button");

		// Fill in the Message Subject
		// WebElement element2 = driver.findElement(By.id("MessageSubject"));
		// element2.sendKeys("Test Message");

		// Print a log message to the screen
		// System.out.println("Successfully added the message subject");

		// Fill in the message Body
		// WebElement element3 = driver.findElement(By.id("MessageBody"));
		// element3.sendKeys("This is a message sent by a Selenium test
		// script.\nPlease ignore and do NOT reply.\nThe message is Sent To All
		// My Connections.");

		// Print a log message to the screen
		// System.out.println("Successfully added the message body");

		// Send the message
		// WebElement element4 = driver.findElement(By.xpath("//a[@class='button
		// button-3 float_left j-form-ajax-submit']"));
		// element4.click();
	}
}
