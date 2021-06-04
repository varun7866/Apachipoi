package com.Test.Scenario;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Windowhandledemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Varunkumar.Panjala\\Downloads\\Google-Recaptcha-Solver-SeleniumAutomation-master\\src\\test\\resources\\drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector(".blinkingText")).click();
		Set<String> windoId = driver.getWindowHandles();
		Iterator<String> id = windoId.iterator();
		String Parentwindow = id.next();
		String childWindow = id.next();
		driver.switchTo().window(childWindow);
		WebElement ele = driver.findElement(By.cssSelector(".im-para.red"));
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(ele));
		String email = driver.findElement(By.cssSelector(".im-para.red")).getText().split(" ")[4];
		driver.switchTo().window(Parentwindow);
		driver.findElement(By.cssSelector("#username")).sendKeys(email);
	}

}
