package week5.day2.assignment1;


import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class DeleteLead extends BaseClass{
	@BeforeClass
	public void setUp() {
		fileName="DeleteLead";
	}
	@Test(dataProvider = "getData")
	public void deleteLead(String ph) throws InterruptedException {
		

				// Click Leads link
				driver.findElement(By.linkText("Leads")).click();

				// Click Find leads
				driver.findElement(By.linkText("Find Leads")).click();

				// Click on Phone
				driver.findElement(By.xpath("//span[@Class='x-tab-strip-inner']/span[text()='Phone']")).click();
				
				// Enter phone number
				driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(ph);
				
				// Click find leads button
				driver.findElement(By.xpath("//button[@Class='x-btn-text'][text()='Find Leads']")).click();
				Thread.sleep(2000);
				
				// Capture lead ID of First Resulting lead
				String LeadID = driver.findElement(By.xpath("//div[@Class='x-grid3-cell-inner x-grid3-col-partyId']/a[1]"))
						.getText();
				System.out.println(LeadID);
				Thread.sleep(2000);
				
				// Click First Resulting lead
				driver.findElement(By.xpath("//div[@Class='x-grid3-cell-inner x-grid3-col-partyId']/a[1]")).click();
				Thread.sleep(2000);
				
				// Click Delete
				driver.findElement(By.xpath("//a[text()='Delete']")).click();
				Thread.sleep(2000);
				
				// Click Find leads
				driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
				
				// Enter captured lead ID
				driver.findElement(By.xpath("//input[@Name='id']")).sendKeys(LeadID);
				
				// Click find leads button
				driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
				Thread.sleep(3000);
				
				String result = driver.findElement(By.xpath("//div[@Class='x-paging-info']")).getText();
				
				//System.out.println(result);
				
				if (result.equals("No records to display")) {
					System.out.println("Record is deleted");
				} else {
					System.out.println("No records to display");
				}
				
				// Close the browser (Do not log out)
	}
}
