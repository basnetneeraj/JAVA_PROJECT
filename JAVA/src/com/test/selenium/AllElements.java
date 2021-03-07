package com.test.selenium;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AllElements {
	
	 public WebDriver driver;
	 public String baseULR = "https://formy-project.herokuapp.com/";
	 public String driverPath = "D:\\Automation\\chromedriver_win32\\chromedriver.exe";
			 
	
	@BeforeTest 
	
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test(priority = 1, description = "Prerequisite action before Test run")
	
	//TestNG Annotation, Priority & Description
	public void completeWebForm() throws InterruptedException {
		driver.get(baseULR);
		System.out.println("Browser Launched Successfully");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement completewebformlink = driver.findElement(By.xpath("//div/li//a[text()='Complete Web Form']"));
		completewebformlink.click();
		System.out.println("Clicked on Complete Web Form");
		Thread.sleep(2000);
		String expectedTitle = "Formy";
		String actualTitleString = driver.getTitle();
		Assert.assertEquals(actualTitleString, expectedTitle);
	}
		
	@AfterTest
	
	public void terminateBrowser() {
		driver.quit();
	}
	

}
