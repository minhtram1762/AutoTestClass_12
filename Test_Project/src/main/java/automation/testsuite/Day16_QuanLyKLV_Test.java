package automation.testsuite;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
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
		if (driver == null) {
	        throw new RuntimeException("WebDriver is null in addKLV_successfully!");
	    }

	    Day16_CSSystem_QuanLyKVLV crm = new Day16_CSSystem_QuanLyKVLV(driver);
	    crm.LoginFunction("admin@gmail.com", "12345678");
	    crm.addKLV("KLV Tram Test", "090320251640");
		assertTrue(driver.findElement(By.xpath("//a[@class='navbar-brand' and normalize-space()='Quản lý khu làm việc']")).isDisplayed());
	}
		
}


