package week5.day2.assignment2;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;
import week5.day2.assignment1.ReadExcel;

public class BaseClass {
	
	public String fileName;

	@DataProvider(name = "getData")
	public String[][] fetchData() throws IOException {

		return ReadExcel.readData(fileName);

	}
	public ChromeDriver driver;

	@Parameters({ "url", "username", "password" })
	@BeforeMethod
	public void preCondition(@Optional("https://dev127173.service-now.com") String url, String uName, String pwd) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
			
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


				// Step2: Enter username (Check for frame before entering the username)
				driver.findElement(By.xpath("//input[@Id='user_name']")).sendKeys(uName);

				// Step3: Enter password
				driver.findElement(By.xpath("//input[@Id='user_password']")).sendKeys(pwd);

				// Step4: Click Login
				driver.findElement(By.xpath("//button[@Id='sysverb_login']")).click();

				Thread.sleep(15000);

				Shadow shadow = new Shadow(driver);

				// Search “incident “ Filter Navigator"
				WebElement filter = shadow.findElementByXPath("//div[@class='starting-header-zone']//div[@id='all']");
				filter.click();
				Thread.sleep(2000);
				shadow.findElementByXPath("//label[@for='filter']/following-sibling::input[@id='filter']")
						.sendKeys("Incidents");
				filter.click();
				Thread.sleep(2000);

				//shadow.findElementByXPath("//span[@class='label']/mark[text()='Incidents']").click();
				shadow.findElementByXPath("//span[@class='item-icon']//mark[text()='Incidents']").click();

				// Click “All”
				WebElement frame = shadow.findElementByXPath("//iframe[@id='gsft_main']");
				driver.switchTo().frame(frame);
				driver.findElement(By.xpath("//span[@id='incident_breadcrumb']//*[text()='All']")).click();

				// Click New button
				shadow.findElementByXPath("//span[@id='incident_choice_actions']/following-sibling::button[@type='submit']")
						.click();
				driver.switchTo().defaultContent();
	}
	
	@AfterMethod
	public void postCondition() {
		driver.close();
	}
}
