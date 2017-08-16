package sampletest;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class FullPageScreenshot {
public static void main(String[] args) throws InterruptedException, IOException {
	System.setProperty("webdriver.chrome.driver","E:\\Navakanth\\Ecllipse Workspace\\Scripts\\Appium\\Appium Project\\Appium Project\\src\\test\\resources\\exe\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	
    // To oepn URL "http://softwaretestingmaterial.com"
driver.get("http://www.softwaretestingmaterial.com");
Thread.sleep(2000);
Screenshot fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
ImageIO.write(fpScreenshot.getImage(),"PNG",new File("D:///FullPageScreenshot.png"));
}

}
