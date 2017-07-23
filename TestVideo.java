package com.mobileweb;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestVideo {
WebDriver driver=null;
String path=System.getProperty("user.dir");
	@Test
	public void testvideo() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", path+"//src//test//resources//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.w3.org/2010/05/video/mediaevents.html");
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById(\"video\").play()");
		
		Thread.sleep(3000);
		
		//pause playing video 
		 js .executeScript("document.getElementById(\"video\").pause()");
		 //Thread.sleep(2000);
		   
		 //js .executeScript("document.getElementById(\"video\").play()");
		   
		 // play video from starting
		 js .executeScript("document.getElementById(\"video\").currentTime=15");
		
		 Thread.sleep(5000);
		   
		 //reload video
		 js .executeScript("document.getElementById(\"video\").load()");
	}
}