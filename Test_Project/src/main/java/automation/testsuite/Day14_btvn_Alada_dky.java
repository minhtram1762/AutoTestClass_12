package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pageLocator.Day14_RegisterPageFactory_Alada;
import automation.pageLocator.loginPage;

public class Day14_btvn_Alada_dky extends CommonBase 
{
	@BeforeMethod
	public void openBrowser()
	{
		driver = initBrowser("firefox", CT_PageURL.URL_ALADA_DKy);
	}

	@Test(priority = 1)
	public void RegisterSuccessfully()
	//dang ky tai khoan moi
	{
		Day14_RegisterPageFactory_Alada login = new Day14_RegisterPageFactory_Alada (driver);
		login.RegisterFunction("Tram Le", "minhtramtest_2@gmail.com", "minhtramtest_2@gmail.com", "1234567", "1234567", "0919999999");
		assertTrue(driver.findElement(By.xpath("//a[text()='Khóa học của tôi' and @class='fleft martop20 khct']")).isDisplayed());
	}
	
	
}
