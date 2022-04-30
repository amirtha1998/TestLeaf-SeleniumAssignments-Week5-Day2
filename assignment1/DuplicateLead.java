package week5.day2.assignment1;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class DuplicateLead extends BaseClass {
	
	@BeforeClass
	public void setUp() {
		fileName="DuplicateLead";
	}
	@Test(dataProvider = "getData")
	public void duplicateLead(String cName, String fName,String dName) {

	
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cName);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fName);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("S");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys(dName);
		driver.findElement(By.name("submitButton")).click();
		driver.findElement(By.linkText("Duplicate Lead")).click();
        driver.findElement(By.id("createLeadForm_companyName")).clear();
        driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Test Leaf");
        driver.findElement(By.id("createLeadForm_firstName")).clear();
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Amirtha");
		driver.findElement(By.className("smallSubmit")).click();


	}
}
