package com.test.selenium;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AllElements {
	@Test
	public void prerequisite() {
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://formy-project.herokuapp.com/");
		driver.findElement(By.xpath("//div/li//a[text()='Complete Web Form']")).click();
	}
	
	public void getSite() {
		AllElements obj = new AllElements();
	}
	
	public static void main(String[] args) {
		
		
		
	}

}
