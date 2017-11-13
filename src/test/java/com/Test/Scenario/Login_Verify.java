package com.Test.Scenario;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import com.Test.Utility.Testutils;


public class Login_Verify {	
		
		 WebDriver driver;
		String baseURL = "http://newtours.demoaut.com/";
		
		@BeforeTest
		public void openBrowser() {		
			
		System.setProperty("webdriver.chrome.driver","C:\\Users\\varun\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://newtours.demoaut.com/");
		}
				
		
		@Test(dataProvider="Authentication")
		public void login_TestCase(String Username,String Password) {
		 String u=Username;
		 String p=Password;
		 System.out.println(p);
			
			WebDriverWait wait=new WebDriverWait(driver, 20);
		
			
			try{
				String UsernameXpath="//input[@name='userName']";
				String PasswordXpath="//input[@name='password']";
				String SigninXpath="//input[@name='login']";
				String SignOffXpath="//a[text()='SIGN-OFF']";
				
				
				driver.findElement(By.xpath(UsernameXpath)).sendKeys(u);;
				
			    driver.findElement(By.xpath(PasswordXpath)).sendKeys(p);;
				
				driver.findElement(By.xpath(SigninXpath)).click();;
				
				
				
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(SignOffXpath)));
				WebElement SignOff=driver.findElement(By.xpath(SignOffXpath));
				boolean verify=SignOff.isDisplayed();
				Assert.assertTrue(verify);
				SignOff.click();
				
				
			}catch(Exception e){
				File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				try {
					FileUtils.copyFile(src, new File("Filepath"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			

		
		}

	    @DataProvider
	 
	    public Object[][] Authentication() throws Exception{
	 
	         

	         Object[][] testObjArray = Testutils.getTableArray("C:\\Users\\varun\\Desktop\\TestData.xlsx","Sheet1");
	 
	         return (testObjArray);}	 
		
		
		
		@AfterTest
		public void closeBrowser() {
			driver.quit();
		}

		
		
		


}
