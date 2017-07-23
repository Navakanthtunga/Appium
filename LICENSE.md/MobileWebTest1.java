package com.mobileweb;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class MobileWebTest1 {
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
		driver.get("http://automationtesting.in/");
		Thread.sleep(2000);
		driver.findElement(By.id("menu-icon")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("menu-icon-close")).click();
		driver.findElement(By.id("menu-icon")).click();
		Thread.sleep(1000);
/*		Dimension size=driver.manage().window().getSize();
		int startx=(int) (size.width*0.5);
		int starty=(int) (size.height*0.5);
		int endy=(int) (size.height*0.8);
		driver.swipe(startx, starty, startx, endy, 1);*/
	
		
		WebElement demoSite=driver.findElement(By.xpath("//a[text()='Demo Site']"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,500)", "");
		
		if(demoSite.isDisplayed()){
			demoSite.click();
		}
		
		
	}
}
