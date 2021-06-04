package com.Test.Scenario;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Varunkumar.Panjala\\Downloads\\Google-Recaptcha-Solver-SeleniumAutomation-master\\src\\test\\resources\\drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("https://www.amazon.com");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		Actions action=new Actions(driver);
		
		action.moveToElement(driver.findElement(By.cssSelector("#nav-link-accountList-nav-line-1"))).build().perform();
		
		WebElement element=driver.findElement(By.cssSelector("#twotabsearchtextbox"));
		
		action.moveToElement(element).click().keyDown(Keys.SHIFT).sendKeys("varun").doubleClick().contextClick().build().perform();
				
		
	}

}
