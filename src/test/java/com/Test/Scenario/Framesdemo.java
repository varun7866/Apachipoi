package com.Test.Scenario;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Framesdemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Varunkumar.Panjala\\Downloads\\Google-Recaptcha-Solver-SeleniumAutomation-master\\src\\test\\resources\\drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();

		driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));
		Actions action=new Actions(driver);
		WebElement ele1=driver.findElement(By.cssSelector("#draggable"));
		WebElement ele2=driver.findElement(By.cssSelector("#droppable"));
		action.dragAndDrop(ele1,ele2).build().perform();;
		
		
		System.out.println("dragged");
		driver.switchTo().defaultContent();
	}

}
