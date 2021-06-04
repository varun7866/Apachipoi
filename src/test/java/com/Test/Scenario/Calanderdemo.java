package com.Test.Scenario;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calanderdemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Varunkumar.Panjala\\Downloads\\Google-Recaptcha-Solver-SeleniumAutomation-master\\src\\test\\resources\\drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.path2usa.com/travel-companions");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.cssSelector("[name='travel_date']")).click();
		
		while(!driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText().contains("August")) {
			
			driver.findElement(By.cssSelector(".next")).click();
		}
		
		List<WebElement> days=driver.findElements(By.cssSelector(".day"));
		
		/*
		 * for(int i=0;i<days.size();i++) {
		 * if(driver.findElements(By.cssSelector(".day")).get(i).getText().equals("15"))
		 * { driver.findElements(By.cssSelector(".day")).get(i).click(); } }
		 */
		
		for(WebElement day:days) {
			if(day.getText().equals("15"))
				day.click();
		}

	}

}
