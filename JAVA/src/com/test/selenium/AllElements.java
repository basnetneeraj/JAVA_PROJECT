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
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Test(priority = 1, description = "Prerequisite action before Test run")
	
	//TestNG Annotation, Priority & Description
	public void completeWebForm() throws InterruptedException {
		System.out.println("=====================START OF TEST=====================");
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
		WebElement firstNameElement, lastNameElement, jobTitlElement, highestLevelOfEducation, sex, yearsOfExperience, date, submitButtonElement;
		String fnameString = "Neeraj";
		String lnameString = "Basnet";
		String jTitle = "Test lead";
		firstNameElement =  driver.findElement(By.xpath("//input[@placeholder='Enter first name']"));
		firstNameElement.sendKeys(fnameString);
		System.out.println("Step 1 - First Name entered successfully");
		lastNameElement = driver.findElement(By.xpath("//input[@placeholder='Enter last name']"));
		lastNameElement.sendKeys(lnameString);
		System.out.println("Step 2 - Last Name entered successfully");
		jobTitlElement = driver.findElement(By.xpath("//input[@placeholder='Enter your job title']"));
		jobTitlElement.sendKeys(jTitle);
		System.out.println("Step 3 - Job Title entered successfully");
		highestLevelOfEducation = driver.findElement(By.xpath("//input[@id='radio-button-3']"));
		highestLevelOfEducation.click();
		System.out.println("Step 4 - Highest Level Of Education Selected successfully");
		sex = driver.findElement(By.xpath("//input[@id='checkbox-1']"));
		sex.click();
		System.out.println("Step 5 - Sex Selected successfully");
		yearsOfExperience = driver.findElement(By.xpath("//option[text()='10+']"));
		yearsOfExperience.click();
		System.out.println("Step 6 - Years Of Experience Selected successfully");
		date = driver.findElement(By.xpath("//input[@id='datepicker']"));
		date.sendKeys("12/01/2021");
		System.out.println("Step 7 - Date Selected successfully");	
		String getFirstNametext = firstNameElement.getAttribute("value");
		Assert.assertEquals(getFirstNametext, fnameString);
		System.out.println("Step 8 - First Name verified");
		String getLastNameString = lastNameElement.getAttribute("value");
		Assert.assertEquals(getLastNameString, lnameString);
		System.out.println("Step 9 - Last Name verified");
		submitButtonElement = driver.findElement(By.xpath("//a[text()='Submit']"));
		submitButtonElement.click();
		System.out.println("Step 10 - Submit Button selected successfully");
		String expectedTitleForm = "Formy";
		String actualTitleStringForm = driver.getTitle();
		Assert.assertEquals(expectedTitleForm, actualTitleStringForm);
		System.out.println("Step 11 - Page Title matched successfully");
		WebElement successsText = driver.findElement(By.xpath("//div[contains(text(),'The form was successfully submitted!')]"));
		String successsMessageTextString = successsText.getText();
		String actualSuccessTextString = "The form was successfully submitted!";
		Assert.assertEquals(actualSuccessTextString, successsMessageTextString);
		System.out.println("Step 12 - Page success message verified");
		System.out.println("=====================END OF TEST=====================");
		
		
		
		
		
	}
		
	@AfterTest
	
	public void terminateBrowser() {
		driver.quit();
	}
	

}
