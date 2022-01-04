package testNGMavenFile;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testNGFirstEX {

	String baseURL="https://www.selenium.dev/downloads/";
	WebDriver driver=new ChromeDriver();
	
  @BeforeTest
  public void verifyHomePageTitle() {
	  System.out.println("Open Browser");
	  driver.get(baseURL);
	  String expectedRes="Downloads | Selenium";
	  String ActualRes=driver.getTitle();
	  AssertJUnit.assertEquals(expectedRes,ActualRes);
	  
  }
  @AfterTest
  public void existDriver() {
	  driver.close();
	  System.out.println("Bye");
  }
  
  @Test   //(priority=1)//first Test will work
  public void cTest() {
	  System.out.println("hello from cTest");
	 
  }
  
  @Test (priority=1,alwaysRun=true)
  public void bTest() {
	  System.out.println("hello from bTest");
	 
  }
  
  @Test (priority=3)
  public void aTest() {
	  System.out.println("hello from aTest");
	 
  }
  @Test //(priority=3)
  public void dTest() {
	  System.out.println("hello from dTest");
	 
  }
}
