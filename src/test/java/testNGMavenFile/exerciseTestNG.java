package testNGMavenFile;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class exerciseTestNG {

	String baseURL="http://demo.guru99.com/test/newtours/";
	static WebDriver driver=new ChromeDriver();
	String CurrentTitle;
	
  @BeforeTest
  public void verifyHomePageTitle() {
	  System.out.println("open page");
	  driver.get(baseURL);	
	  AssertJUnit.assertEquals(driver.getTitle(),"Welcome: Mercury Tours");	  

  }

  @Test (priority=1)
  public void ClickRegister() {
		WebElement RegisterBtn = driver.findElement(By.linkText("REGISTER"));
		RegisterBtn.click();
		CurrentTitle="Register: Mercury Tours";
		
  }
  @Test(priority=2)
  public void clickSupport() {
		WebElement SupportBtn = driver.findElement(By.linkText("SUPPORT"));
		SupportBtn.click();
		CurrentTitle="Under Construction: Mercury Tours";
		
  }
  @AfterMethod
  public void  openHome(){
	  AssertJUnit.assertEquals(driver.getTitle(),CurrentTitle);
	  System.out.println("checkTitle:"+driver.getTitle());
	  
	  driver.findElement(By.linkText("Home")).click();
	  AssertJUnit.assertEquals(driver.getTitle(),"Welcome: Mercury Tours");
  }
  
  
  @AfterTest
  public void existDriver() {
	  driver.close();
	  System.out.println("Bye");
  }
 

}
