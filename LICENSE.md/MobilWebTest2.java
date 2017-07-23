package com.mobileweb;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class MobilWebTest2 {
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
		WebElement alertsText=driver.findElement(By.xpath("//a[text()='Alerts']"));
		alertsText.click();
		Thread.sleep(4000);
		WebElement alertOne=driver.findElement(By.id("OKTab"));
		alertOne.click();
		Thread.sleep(4000);
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		WebElement alertTwo=driver.findElement(By.xpath("//a[text()='Alert with OK & Cancel ']"));
		alertTwo.click();
		Thread.sleep(2000);
		WebElement alertTwoLnk=driver.findElement(By.id("CancelTab"));
		alertTwoLnk.click();
		Thread.sleep(4000);
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();
		Thread.sleep(4000);
		WebElement eleCancel=driver.findElement(By.xpath("//p[text()='You Pressed Cancel']"));
		System.out.println(eleCancel.isDisplayed());
		Thread.sleep(4000);
		alertTwoLnk.click();
		Thread.sleep(4000);
		driver.switchTo().alert().accept();
		Thread.sleep(4000);
		WebElement eleOk=driver.findElement(By.xpath("//p[text()='You pressed Ok']"));
		System.out.println(eleOk.isDisplayed());
		WebElement alertThree=driver.findElement(By.xpath("//a[text()='Alert with Textbox ']"));
		alertThree.click();
		WebElement alertThreeLnk=driver.findElement(By.id("Textbox"));
		alertThreeLnk.click();
	}
}