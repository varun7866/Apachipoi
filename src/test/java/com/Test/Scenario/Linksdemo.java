package com.Test.Scenario;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;import org.yaml.snakeyaml.nodes.AnchorNode;

public class Linksdemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Varunkumar.Panjala\\Downloads\\Google-Recaptcha-Solver-SeleniumAutomation-master\\src\\test\\resources\\drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("http://qaclickacademy.com/practice.php");
		driver.manage().window().maximize();
		
		
	// 1. get number of links present in the page.
		
		System.out.println(driver.findElements(By.tagName("a")).size());
		
	// 2. get number links present in footer section	
		
		WebElement footer=driver.findElement(By.cssSelector("#gf-BIG"));// Limiting webdriver scope
		
		System.out.println(footer.findElements(By.tagName("a")).size());
		
	// 3.get the number of links present in the first coloumn in footer section
		
		
		WebElement firstColumn=footer.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));// Limiting webdriver scope
		
		List<WebElement> links=firstColumn.findElements(By.tagName("a"));
		System.out.println(links.size());
		
	//4. swith to each tab and get the title	
		for(int i=1;i<links.size();i++) {			
			links.get(i).sendKeys(Keys.chord(Keys.CONTROL,Keys.ENTER));
		}
		
		Set<String> windows=driver.getWindowHandles();
		Iterator<String> it=windows.iterator();
		
		while(it.hasNext()) {
			
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
			driver.close();
		}
	}

}
