/**
 * 
 */
package week5.day2.assignment1;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.By;


public class CreateContact extends BaseClass{
	
	@BeforeClass
	public void setUp() {
		fileName="CreateContact";
	}
	@Test(dataProvider = "getData")
	public void createContact(String fName, String dName,String desc) {

		
		// Click on contacts Button
		driver.findElement(By.linkText("Contacts")).click();

		// Click on Create Contact
		driver.findElement(By.linkText("Create Contact")).click();

		// Enter FirstName Field Using id Locator
		driver.findElement(By.id("firstNameField")).sendKeys(fName);

		// Enter LastName Field Using id Locator
		driver.findElement(By.id("lastNameField")).sendKeys("S");

		// Enter Department Field Using any Locator of Your Choice
		driver.findElement(By.xpath("//input[@id='createContactForm_departmentName']")).sendKeys(dName);
		
		// Enter Description Field Using any Locator of your choice
		driver.findElement(By.id("createContactForm_description")).sendKeys(desc);

		
		// Click on Create Contact
		driver.findElement(By.name("submitButton")).click();

		// Click on edit button
		driver.findElement(By.linkText("Edit")).click();

		// Clear the Description Field using .clear

		driver.findElement(By.id("updateContactForm_description")).clear();

		// Fill ImportantNote Field with Any text
		driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("Selenium Training");

		// Click on update button using Xpath locator
		driver.findElement(By.xpath("//input[@value='Update']")).click();


	}

}
