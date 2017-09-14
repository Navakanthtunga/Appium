package com.practise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.FirefoxDriverManager;

public class DataProviders {
	private static WebDriver driver;
	 
	  @DataProvider(name = "Authentication")
	 
	  public static Object[][] credentials() {
	 
	        return new Object[][] { { "testuser_1", "Test@123" }, { "testuser_9", "Test@1243" }};
	 
	  }
	 
	  // Here we are calling the Data Provider object with its Name
	 
	  @Test(dataProvider = "Authentication")
	 
	  public void test(String sUsername, String sPassword) {
		  
		  FirefoxDriverManager.getInstance().setup();
		  
		  driver = new FirefoxDriver();
	 
	      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 
	      driver.get("http://www.store.demoqa.com");
	 
	      driver.findElement(By.xpath(".//*[@id='account']/a")).click();
	 
	      System.out.println(sUsername);
	      
	      System.out.println(sPassword);
	      
	      driver.findElement(By.id("log")).sendKeys(sUsername);
	      
	 
	      driver.findElement(By.id("pwd")).sendKeys(sPassword);
	      try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      
	      driver.findElement(By.id("log")).clear();
	      
	 	 
	      driver.findElement(By.id("pwd")).clear();
	      
//	      driver.findElement(By.id("login")).click();
//	 
//	      driver.findElement(By.xpath(".//*[@id='account_logout']/a")).click();
	 
	      driver.quit();
	 
	  }
}
