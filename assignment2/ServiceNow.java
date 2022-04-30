package week5.day2.assignment2;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
//unable to find the INC created
//to reopen the ticket

import io.github.sukgu.Shadow;

public class ServiceNow extends BaseClass{
	
	@BeforeClass
	public void setUp() {
		fileName="ServiceNow";
	}
	
	@Test(dataProvider="getData")
	public void serviceNow(String description) throws InterruptedException {
		
		Shadow shadow = new Shadow(driver);
		WebElement frame = shadow.findElementByXPath("//iframe[@id='gsft_main']");

		driver.switchTo().frame(frame);
		shadow.findElementByXPath("//button[@id='lookup.incident.caller_id']").click();
		driver.switchTo().defaultContent();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> window = new ArrayList<String>(windowHandles);
		Thread.sleep(2000);
		driver.switchTo().window(window.get(1));
		driver.findElement(By.xpath("//tbody[@class='list2_body']/tr[1]//a")).click();
		driver.switchTo().window(window.get(0));
		driver.switchTo().frame(frame);
		driver.findElement(By.xpath("//input[@id='incident.short_description']"))
				.sendKeys(description);

		// Read the incident number and save it a variable
		String incidentNumber = driver.findElement(By.xpath("//input[@id='incident.number']")).getAttribute("value");

		// Click on Submit button
		driver.findElement(By.xpath("//span[@class='ui_action_container_primary']//button[@type='submit']")).click();
		driver.switchTo().defaultContent();

		// Search the same incident number in the next search screen as below
		driver.switchTo().frame(frame);
		WebElement incidentSearch = driver
				.findElement(By.xpath("//label[text()='Search']/following-sibling::input[@placeholder='Search']"));
		incidentSearch.sendKeys(incidentNumber);
		Thread.sleep(2000);
		incidentSearch.sendKeys(Keys.ENTER);
		driver.switchTo().defaultContent();

		// Verify the incident is created successful.
		driver.switchTo().frame(frame);
		String incident = driver.findElement(By.xpath("//tbody[@class='list2_body']/tr[1]/td[3]/a")).getText();

		if (incident.equals(incidentNumber)) {
			System.out.println(incident + " is Created");
		} else {
			System.out.println("Incident is not Created");
		}
				
	}
}
