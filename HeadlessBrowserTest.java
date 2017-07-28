package sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessBrowserTest {
	static WebDriver driver;
public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "D:\\Demo workspace\\sample\\resources\\chromedriver.exe");
	
	ChromeOptions options=new ChromeOptions();
	//to know all the commands that can be specified inside addArguments refer 
	/*
	 * https://chromium.googlesource.com/chromium/src/+/master/chrome/common/chrome_switches.cc
	 * https://chromium.googlesource.com/chromium/src/+/master/chrome/common/pref_names.cc
	 */
	
	options.addArguments("headless");
	options.addArguments("window-size-1600,400");
	driver 	=new ChromeDriver(options);
	driver.get("https://www.google.com");
	driver.manage().window().maximize();
	driver.findElement(By.xpath("//a[@id='gb_70']")).click();
	System.out.println("url"+driver.getCurrentUrl());
	System.out.println("title"+driver.getTitle());
	driver.quit();
}
}
