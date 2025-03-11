package automation.testsuite;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pageLocator.Day17_PopupPage;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Day17_Popup_Test extends CommonBase
{
	@BeforeMethod
	public void openBrowser() 
	{
		driver = initBrowser("firefox",CT_PageURL.URL_GURU99);
		if (driver == null) 
		{
		   throw new RuntimeException("WebDriver is null after initialization!");
		}
		System.out.println("Driver initialized in openBrowser: " + driver);
	}
	
	@Test
	public void testPopup()
	{
		Day17_PopupPage popupPage = new Day17_PopupPage(driver);
		popupPage.handleChildWindow();
		String actualURL = driver.getCurrentUrl();
		String expectedURL = "https://demo.guru99.com/popup.php";
		assertEquals(actualURL, expectedURL);
	}
	
}
