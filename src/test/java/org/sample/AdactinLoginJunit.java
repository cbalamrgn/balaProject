package org.sample;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AdactinLoginJunit {
	static WebDriver driver;
	
	@BeforeClass
	public static void beforeClass() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://adactinhotelapp.com/");
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public static void afterClass() {
		driver.quit();
	}
	
	@Before
	public void beforeMethod() {
		Date date = new Date();
		System.out.println(date);
	}
	
	@After
	public void afterMethod() {
		Date date = new Date();
		System.out.println(date);
	}
	
	@Test
	public void test() throws InterruptedException {
		WebElement txtUserName = driver.findElement(By.id("username"));
		txtUserName.sendKeys("balamrgn");
		WebElement txtPassword = driver.findElement(By.id("password"));
		txtPassword.sendKeys("balamrgn");
		Thread.sleep(200);
		WebElement btnLogin = driver.findElement(By.name("login"));
		btnLogin.click();
	}
	
}
