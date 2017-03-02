package base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class TC_Base {

	protected WebDriver driver;

	protected TC_Base() {

		// Create a new instance of the Firefox driver
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver-v0.14.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();

		// Launch https://staging.joordev.com website
		driver.get("https://staging.joordev.com/");

		// Print a log message to the screen
		System.out.println("Successfully opened https://staging.joordev.com/");
	}

	protected void login() throws InterruptedException {
		Thread.sleep(5);

		// Click on the Login button
		driver.findElement(By.className("login-button")).click();

		Thread.sleep(500);

		// Fill in the Login Name field
		WebElement element = driver.findElement(By.id("login-name"));
		element.sendKeys("qatest1");

		// Fill in the Email field
		WebElement element1 = driver.findElement(By.name("data[User][password]"));
		element1.sendKeys("qatest1");
		// and submit
		element1.sendKeys(Keys.RETURN);

		Thread.sleep(1000);

		// Print a log message to the screen
		System.out.println("Successfully logged in to https://staging.joordev.com/");
	}

	protected void logout() throws InterruptedException {
		// Click on Regress Java button
     	driver.findElement(By.xpath("//span[contains(.,'Regress Java')]")).click();
     	Thread.sleep(3000);
     				
     	// Click on Logout button
     	driver.findElement(By.xpath("//a[@href='/users/logout']")).click();
     				
     	// Print a log message to the screen
     	System.out.println("Successfully logged out");		
     	Thread.sleep(2000);
	}
	
	protected void close() {
		// Close the driver
		driver.quit();
		
		// Print a log message to the screen
		System.out.println("The brower's closed");
	}

}
