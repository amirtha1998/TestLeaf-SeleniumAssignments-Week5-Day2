package week5.day2.assignment1;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public ChromeDriver driver;
	public String fileName;

	@Parameters({ "url", "username", "password" })
	@BeforeMethod
	public void preCondition(String url, String uName, String pwd) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.findElement(By.id("username")).sendKeys(uName);
		driver.findElement(By.id("password")).sendKeys(pwd);
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();

	}

	@AfterMethod
	public void postCondition() {
		driver.close();
	}

	@DataProvider(name = "getData")
	public String[][] fetchData() throws IOException {

		return ReadExcel.readData(fileName);

	}
}