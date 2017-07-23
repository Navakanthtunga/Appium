package com.mobileweb;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class MobileWebTestTab1 {
	public AndroidDriver<MobileElement> driver;
	DesiredCapabilities capabilities;
	@Test
	public void lauchChrome() throws MalformedURLException, InterruptedException{
		capabilities = new DesiredCapabilities();
		capabilities.setCapability("automationName","Appium");
		capabilities.setCapability("platformName","Android");
		capabilities.setCapability("platformVersion","6.0");
		capabilities.setCapability("deviceName","HNB22TFC");
		capabilities.setCapability("browserName","Chrome");
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://demo.automationtesting.in/Register.html");
		Thread.sleep(5000);
		WebElement hamburger=driver.findElement(By.xpath("//button[@class='btn btn-success navbar-toggle']"));
		hamburger.click();
		Thread.sleep(2000);
		WebElement switchTo=driver.findElement(By.xpath("//a[text()='SwitchTo']"));
		switchTo.click();
		Thread.sleep(3000);
		WebElement windowsText=driver.findElement(By.xpath("//a[text()='Windows']"));
		windowsText.click();
		Thread.sleep(4000);
		int tabCountOne=driver.getWindowHandles().size();
		System.out.println(tabCountOne);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)", "");
		Thread.sleep(2000);
		WebElement clickButton=driver.findElement(By.xpath("//a[@href='http://www.sakinalium.in']"));
		clickButton.sendKeys(Keys.ENTER);;
		Thread.sleep(2000);
		 ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		 System.out.println("Size "+tabs2.size());
		    driver.switchTo().window("CDwindow-1");//tabs.get(0)
		    System.out.println(tabs2.get(0).toString());
		    System.out.println(tabs2.get(1).toString());
		    System.out.println(driver.getCurrentUrl());
		    System.out.println(driver.getTitle());
		    driver.close();
		    driver.switchTo().window("CDwindow-0");//tabs.get(0)
		    driver.close();
	}
}