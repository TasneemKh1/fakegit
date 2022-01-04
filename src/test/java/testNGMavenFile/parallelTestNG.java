package testNGMavenFile;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class parallelTestNG {


		// TODO Auto-generated method stub
		String baseURL="https://demo.guru99.com/V4/";
		

	    @Test 
	    public void session1() {
	    	WebDriver driver=new ChromeDriver();
	  	    driver.get(baseURL);
	  		WebElement name=driver.findElement(By.name("uid"));	       
	  		name.sendKeys("Tasneem");
	    }
	    @Test 
	    public void session2() {
	    	WebDriver driver=new ChromeDriver();
	  	    driver.get(baseURL);
	  		WebElement name=driver.findElement(By.name("uid"));	 
		    name.sendKeys("Tasneem2");
	  		
	    }
	    @Test 
	    public void session3() {
	    	WebDriver driver=new ChromeDriver();
	  	    driver.get(baseURL);
	  		WebElement name=driver.findElement(By.name("uid"));	 
		    name.sendKeys("Tasneem3");
	    }

}
