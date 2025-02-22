package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pageLocator.loginPage;

public class Day13_Alada_LoginTest extends CommonBase 
{
	@BeforeMethod
	public void openBrowser()
	{
		driver = initBrowser(CT_PageURL.URL_ALADA);
	}
	
	@Test
	public void loginSuccessfully()
	
	{
		loginPage login = new loginPage(driver);
		login.LoginFunction("minhtram1762@gmail.com", "123456");
		//assert Dashboard display
		assertTrue(driver.findElement(By.xpath("//a[text()='Khóa học của tôi' and @class='fleft martop20 khct']")).isDisplayed());
	}

	@Test
	public void loginFail_IncorrectPass()
	{
		loginPage login = new loginPage(driver);
		login.LoginFunction("minhtram1762@gmail.com", "123456_incorrect");
		assertTrue(driver.findElement(By.xpath("//p[text()='Mật khẩu sai.']")).isDisplayed());
	}
		
	@Test
	public void loginFail_IncorrectEmail()
	{
		loginPage login = new loginPage(driver);
		login.LoginFunction("minhtram1762_incorrect@gmail.com", "123456");
		assertTrue(driver.findElement(By.xpath("//p[text()='Email này chưa được đăng ký.']")).isDisplayed());
	}				
}
