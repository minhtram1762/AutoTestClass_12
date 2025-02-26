package automation.testsuite;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pageLocator.LoginPage_CSSystem;

public class Day13_btvn extends CommonBase 
{
    @BeforeMethod
    public void openBrowser()
	{
		driver = initBrowser("firefox",CT_PageURL.URL_CSSYSTEM);
	}
	
	@Test(priority = 1)
	public void loginSuccessfully()
	{
		LoginPage_CSSystem _login = new LoginPage_CSSystem(driver);
		_login.LoginFunction("admin@gmail.com", "12345678");
		assertTrue(driver.findElement(By.xpath("//p[text()='Quản lý người dùng']")).isDisplayed());
	}

	@Test(priority = 2)
	public void loginFail_IncorrectEmail()
	{
		LoginPage_CSSystem _login = new LoginPage_CSSystem(driver);
		_login.LoginFunction("admin_incorrect@gmail.com", "12345678");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	    WebElement flashMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
	            By.xpath("//*[contains(text(), 'Email hoặc mật khẩu không đúng')]")));

	    String messageText = flashMessage.getText();
	    System.out.println("Flash message: " + messageText);

	    // Kiểm tra nội dung flash message
	    assertTrue(messageText.contains("Email hoặc mật khẩu không đúng"), "Flash message không đúng hoặc không xuất hiện!");
	}	
	
	@Test(priority = 3)
	public void loginFail_IncorrectPass()
	{
		LoginPage_CSSystem _login = new LoginPage_CSSystem(driver);
		_login.LoginFunction("admin@gmail.com", "12345678_incorrect");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	    WebElement flashMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
	            By.xpath("//*[contains(text(), 'Email hoặc mật khẩu không đúng')]")));

	    String messageText = flashMessage.getText();
	    System.out.println("Flash message: " + messageText);

	    assertTrue(messageText.contains("Email hoặc mật khẩu không đúng"), "Flash message không đúng hoặc không xuất hiện!");
	}	
	
	@Test(priority = 4)
	public void loginFail_IncorrectEmailPass()
	{
		LoginPage_CSSystem _login = new LoginPage_CSSystem(driver);
		_login.LoginFunction("admin_incorrect@gmail.com", "12345678_incorrect");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	    WebElement flashMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
	            By.xpath("//*[contains(text(), 'Email hoặc mật khẩu không đúng')]")));

	    String messageText = flashMessage.getText();
	    System.out.println("Flash message: " + messageText);

	    assertTrue(messageText.contains("Email hoặc mật khẩu không đúng"), "Flash message không đúng hoặc không xuất hiện!");
	}	
	
	@Test(priority = 5)
	public void logoutSuccessfully()
	
	{
		LoginPage_CSSystem _login = new LoginPage_CSSystem(driver);
		_login.LoginFunction("admin@gmail.com", "12345678");
		LoginPage_CSSystem logout = new LoginPage_CSSystem(driver);
		logout.LogoutFunction();
		assertTrue(driver.findElement(By.xpath("//h4[text()='Đăng nhập']")).isDisplayed());
	}
	
}
