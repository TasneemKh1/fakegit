package testNGMavenFile;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class screenShotsTest {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		String baseURL = "https://www.newegg.com/";
		WebDriver driver = new ChromeDriver(); 
		//WebDriver driver = new FirefoxDriver(); 

		
		driver.get(baseURL);
	//	driver.manage().window().maximize();
//		Screenshot screenshot =new AShot().takeScreenshot(driver);
//		File image=new File("/Users/tasneem/Desktop/imagenew.png");
//		ImageIO.write(screenshot.getImage(),"png",image);
//------------------------------------full-page screenshot-------------------------------------		
//		Screenshot Screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
//		ImageIO.write(Screenshot.getImage(), "jpg", new File("/Users/tasneem/Desktop/ElementScreenshot.jpg"));
//------------------------------------particulher screenshot-------------------------------------		
		
		WebElement element = driver.findElement(By.cssSelector (".header2021-search>form"));
		Screenshot Screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver,element);
		ImageIO.write(Screenshot.getImage(), "jpg", new File("/Users/tasneem/Desktop/partElementScreenshot.jpg"));	
		
		BufferedImage expectedImage = ImageIO.read(new File("/Users/tasneem/Desktop/partElementScreenshot.jpg"));
		BufferedImage actualImage= Screenshot.getImage();
		ImageIO.write(Screenshot.getImage(), "jpg", new File("/Users/tasneem/Desktop/partElementScreenshot2.jpg"));	

		ImageDiffer diff= new ImageDiffer();
		ImageDiff result=diff.makeDiff(expectedImage, actualImage);
		Assert.assertFalse(result.hasDiff());
		
	}

}
