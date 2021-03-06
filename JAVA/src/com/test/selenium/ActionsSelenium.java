package com.test.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsSelenium {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://formy-project.herokuapp.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Actions action = new Actions(driver);
		WebElement completeWebFormElement = driver.findElement(By.xpath("//div/li//a[text()='Complete Web Form' and @href='/form']"));
		action.moveToElement(completeWebFormElement).build().perform(); //Move to the element
		System.out.println("Moved to the element");
		completeWebFormElement.click();
		System.out.println("clicked Element");
		driver.quit();
		System.out.println("Driver Quit Successfully");
		
		int i = 10;

	}
	

}
