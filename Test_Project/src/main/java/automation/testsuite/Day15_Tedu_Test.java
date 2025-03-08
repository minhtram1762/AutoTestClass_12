package automation.testsuite;

import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pageLocator.Day15_Tedu_Page;

public class Day15_Tedu_Test<WebElement> extends CommonBase
{	
	String password = "654321";
	@BeforeMethod
	public void openBrowser()
	{
		driver = initBrowser("firefox",CT_PageURL.URL_TEDU);
	}	

	@Test(priority = 1)
	public void loginSuccessfully()
	{
		Day15_Tedu_Page tedu = new Day15_Tedu_Page (driver);
		tedu.loginFunction("minhtram1762@gmail.com", password);
		assertTrue(driver.findElement(By.id("my_account")).isDisplayed());
	}
	
	@Test(priority = 2)
	public void UpdatePassSuccessfully() throws InterruptedException
	{
		loginSuccessfully();
		Thread.sleep(3000);
		Day15_Tedu_Page tedu = new Day15_Tedu_Page (driver);
		tedu.updatePass("654321", "123456");
		password = "123456";
		assertTrue(driver.findElement(By.xpath("//div[contains(text(),'Đổi mật khẩu thành công. Mời bạn đăng nhập lại.')]")).isDisplayed());
	}
	
	@Test(priority = 3)
	public void UpdatePassSuccessfullyBack() throws InterruptedException
	{
		loginSuccessfully();
		Thread.sleep(3000);
		Day15_Tedu_Page tedu = new Day15_Tedu_Page (driver);
		tedu.updatePass("123456", "654321");
		password = "654321";
		assertTrue(driver.findElement(By.xpath("//div[contains(text(),'Đổi mật khẩu thành công. Mời bạn đăng nhập lại.')]")).isDisplayed());
	}

	@Test(priority = 4)
	public void searchKhoaHocSuccessfully() throws InterruptedException
	{
		loginSuccessfully();
		Thread.sleep(3000);
		Day15_Tedu_Page tedu = new Day15_Tedu_Page (driver);
		tedu.searchKhoaHoc("ASP Net");
		List<WebElement> listResults = findElements(By.xpath("//a[@title='*']"));
		for (WebElement item : listResults)
		{
			assertTrue(driver.findElement(By.xpath("//a[text()='Bài 52: Gửi phản hồi và gửi mail trong ASP NET sử dụng SMTP'][1]")).isDisplayed());
		}
	}

	private List<WebElement> findElements(By xpath) 
	{
		return (List<WebElement>) driver.findElements(xpath);
	}
	
}








