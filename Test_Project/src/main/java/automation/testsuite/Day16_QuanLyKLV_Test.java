package automation.testsuite;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pageLocator.Day16_CSSystem_QuanLyKVLV;

public class Day16_QuanLyKLV_Test extends CommonBase
{
	@BeforeMethod
	public void openBrowser() 
	{
		driver = initBrowser("firefox",CT_PageURL.URL_CSSYSTEM);
		if (driver == null) 
		{
		   throw new RuntimeException("WebDriver is null after initialization!");
		}
		System.out.println("Driver initialized in openBrowser: " + driver);
	}
		
	@Test(priority = 1)
	public void addKLV_successfully()
	{
		Day16_CSSystem_QuanLyKVLV crm = new Day16_CSSystem_QuanLyKVLV(driver);
	    crm.LoginFunction("admin@gmail.com", "12345678");
	    crm.addKLV("KLV Tram Test", "090320251640");
		assertTrue(driver.findElement(By.xpath("//a[@class='navbar-brand' and normalize-space()='Quản lý khu làm việc']")).isDisplayed());
	}
		
	@Test(priority = 2)
	public void deleteKLV_successfully()
	{
		Day16_CSSystem_QuanLyKVLV crm = new Day16_CSSystem_QuanLyKVLV(driver);
	    crm.LoginFunction("admin@gmail.com", "12345678");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		click(By.xpath("//a[normalize-space()='Quản lý khu làm việc']"));
		crm.deleteKLV("KLV Tram Test");
		click(By.xpath("//button[text()='Tìm kiếm']"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='KLV Tram Test']")));
		
		click(By.xpath("//a[normalize-space()='Xóa']"));
		String actualMessage = driver.switchTo().alert().getText();
		String expectedMessage = "Bạn có thực sự muốn xóa khu vực này";
		assertEquals(actualMessage, expectedMessage);
		driver.switchTo().alert().accept();
		assertTrue(isElementDisplayed(By.xpath("//h4[text()='Không tìm thấy kết quả']")));
	}
	
	
}


