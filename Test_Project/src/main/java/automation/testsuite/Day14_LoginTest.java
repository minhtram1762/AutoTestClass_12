package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pageLocator.Day14_LoginPageFactory;

public class Day14_LoginTest extends CommonBase 
{
	@BeforeMethod
	public void openBrowser()
	{
		driver = initBrowser("firefox",CT_PageURL.URL_ALADA);
	}	

	@Test(priority = 1)
	public void LoginSuccessfully()
	{
		Day14_LoginPageFactory login = new Day14_LoginPageFactory (driver);
		login.LoginFunction("minhtram1762@gmail.com", "123456");
		assertTrue(driver.findElement(By.xpath("//a[text()='Khóa học của tôi' and @class='fleft martop20 khct']")).isDisplayed());
	}
	
	@Test(priority = 2)
	public void LoginFail_IncorrectPass()
	{
		Day14_LoginPageFactory login = new Day14_LoginPageFactory (driver);
		login.LoginFunction("minhtram1762@gmail.com", "123456_incorrect");
		assertTrue(driver.findElement(By.xpath("//p[text()='Mật khẩu sai.']")).isDisplayed());
	}
	
	@Test(priority = 3)
	public void LoginFail_IncorrectEmail()
	{
		Day14_LoginPageFactory login = new Day14_LoginPageFactory (driver);
		login.LoginFunction("minhtram1762_incorrect@gmail.com", "123456");
		assertTrue(driver.findElement(By.xpath("//p[text()='Email này chưa được đăng ký.']")).isDisplayed());
	}
	
	@Test(priority = 4)
	public void Logout()
	{
		Day14_LoginPageFactory login = new Day14_LoginPageFactory (driver);
		login.LoginFunction("minhtram1762@gmail.com", "123456");
		assertTrue(driver.findElement(By.xpath("//a[text()='Khóa học của tôi' and @class='fleft martop20 khct']")).isDisplayed());
		login.LogoutFunction();
		assertTrue(driver.findElement(By.xpath("//a[text()='Đăng Nhập']")).isDisplayed());
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.close();
	}


}
