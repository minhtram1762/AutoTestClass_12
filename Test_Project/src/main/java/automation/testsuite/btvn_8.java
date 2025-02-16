package automation.testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import automation.common.CommonBase;

public class btvn_8 extends CommonBase {
	@BeforeMethod
	public void openBrowerTest()
	{
		driver = initBrowser("https://automationfc.github.io/basic-form/index.html");
	}
	@Test
	public void locateById()
	{
		WebElement textName = driver.findElement(By.id("name"));
		System.out.println("Name "+textName);
		
		WebElement textAddress = driver.findElement(By.id("address"));
		System.out.println("Address "+ textAddress);
		
		WebElement textEmail = driver.findElement(By.id("email"));
		System.out.println("Email "+ textEmail);
		
		WebElement textPassword = driver.findElement(By.id("password"));
		System.out.println("Password "+ textPassword);
	}
	@Test
	public void locateByName()
	{
		WebElement textName = driver.findElement(By.name("name"));
		System.out.println("Name "+textName);
		
		WebElement textAddress = driver.findElement(By.name("address"));
		System.out.println("Address "+ textAddress);
		
		WebElement textEmail = driver.findElement(By.name("email"));
		System.out.println("Email "+ textEmail);
		
		WebElement textPassword = driver.findElement(By.name("password"));
		System.out.println("Password "+ textPassword);
	}
	
}
