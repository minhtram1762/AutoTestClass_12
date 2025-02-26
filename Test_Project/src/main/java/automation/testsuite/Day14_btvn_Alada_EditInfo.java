package automation.testsuite;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pageLocator.Day14_LoginPageFactory;

public class Day14_btvn_Alada_EditInfo extends CommonBase 
{
	@BeforeMethod
	public void openBrowser()
	{
		driver = initBrowser("firefox",CT_PageURL.URL_ALADA);
	}	

	@Test(priority = 1)
	public void EditSuccessfully()
	{
		Day14_LoginPageFactory login = new Day14_LoginPageFactory (driver);
		login.LoginFunction("minhtramtest_2@gmail.com", "1234567");
		assertTrue(driver.findElement(By.xpath("//a[text()='Khóa học của tôi' and @class='fleft martop20 khct']")).isDisplayed());

	    Day14_LoginPageFactory info = new Day14_LoginPageFactory(driver);
		info.ThongTinCaNhan();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",info.getbuttonLuuMatKhau());
        assertTrue(info.getbuttonLuuMatKhau().isDisplayed(), "Lưu mật khẩu mới");
        
        Day14_LoginPageFactory edit = new Day14_LoginPageFactory(driver);
        edit.ChinhSuaThongTin("1234567", "1234567edit", "1234567edit");
		assertTrue(driver.findElement(By.xpath("//a[text()='Khóa học của tôi' and @class='fleft martop20 khct']")).isDisplayed());
	}
	
	@Test(priority = 2)
	public void LoginNewPasswordSuccessfully()
	{
		Day14_LoginPageFactory login = new Day14_LoginPageFactory (driver);
		login.LoginFunction("minhtramtest_2@gmail.com", "1234567edit");
		assertTrue(driver.findElement(By.xpath("//a[text()='Khóa học của tôi' and @class='fleft martop20 khct']")).isDisplayed());
	}
}


