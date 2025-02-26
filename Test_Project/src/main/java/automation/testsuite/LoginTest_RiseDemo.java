package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pageLocator.loginPage;

public class LoginTest_RiseDemo extends CommonBase

{
	
	@BeforeMethod
	public void openBrowser()
	{
		driver = initBrowser("firefox",CT_PageURL.URL_RISE);
	
	}

	@Test
	public void loginSuccessfully()
	{
		WebElement emailTextbox = driver.findElement(By.id("email"));
		//Xóa giá trị mặc định trong textbox email
		emailTextbox.clear();
		// Nhập admin@demo.com
		emailTextbox.sendKeys("admin@demo.com");
		
		WebElement passwordTextbox = driver.findElement(By.id("password"));
		passwordTextbox.clear();
		passwordTextbox.sendKeys("riseDemo");
		
		//Click button Signin
		WebElement btnSignin = driver.findElement(By.xpath("//button[text()='Sign in']"));
		
}
}

