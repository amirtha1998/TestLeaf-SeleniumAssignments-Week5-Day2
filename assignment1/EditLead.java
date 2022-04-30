package week5.day2.assignment1;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class EditLead extends BaseClass {
	
	@BeforeClass
	public void setUp() {
		fileName="EditLead";
	}

	@Test(dataProvider = "getData")
	public void editLead(String ph, String cName) throws InterruptedException {

		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(ph);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(cName);
		driver.findElement(By.name("submitButton")).click();
		
}
}
