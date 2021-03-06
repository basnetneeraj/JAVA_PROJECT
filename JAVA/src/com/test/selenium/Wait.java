package com.test.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Wait {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //Implicit Wait
		driver.get("https://formy-project.herokuapp.com/");
		WebElement completeWebFormElement = driver.findElement(By.xpath("//div/li//a[text()='Complete Web Form' and @href='/form']"));
		completeWebFormElement.click();
		WebElement firstNamElement = driver.findElement(By.id("first-name"));
		firstNamElement.sendKeys("Neeraj");
	}

}
