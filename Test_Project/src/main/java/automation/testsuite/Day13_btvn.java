package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pageLocator.loginPage;

public class Day13_btvn extends CommonBase 
{
    @BeforeMethod
    public void openBrowser()
	{
		driver = initBrowser("firefox",CT_PageURL.URL_CSSYSTEM);
	}
	
	@Test
	public void loginSuccessfully()
	
	{
		loginPage login = new loginPage(driver);
		login.LoginFunction("admin@gmail.com", "12345678");
		//assert Dashboard display
		assertTrue(driver.findElement(By.xpath("//p[text()='Quản lý người dùng']")).isDisplayed());
	}

	@Test
	public void loginFail_IncorrectEmail()
	{
		loginPage login = new loginPage(driver);
		login.LoginFunction("admin_incorrect@gmail.com", "12345678");
		assertTrue(driver.findElement(By.xpath("//p[text()='Email hoặc mật khẩu không đúng']")).isDisplayed());
	}	
	
	@Test
	public void loginFail_IncorrectPass()
	{
		loginPage login = new loginPage(driver);
		login.LoginFunction("admin@gmail.com", "12345678_incorrect");
		assertTrue(driver.findElement(By.xpath("//p[text()='Email hoặc mật khẩu không đúng']")).isDisplayed());
	}
		
	@Test
	public void loginFail_IncorrectEmailPass()
	{
		loginPage login = new loginPage(driver);
		login.LoginFunction("admin_incorrect@gmail.com", "12345678_incorrect");
		assertTrue(driver.findElement(By.xpath("//p[text()='Mật khẩu sai.']")).isDisplayed());
	}
	
}
