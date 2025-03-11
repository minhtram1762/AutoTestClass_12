package automation.pageLocator;

import static org.testng.AssertJUnit.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.*;


import automation.common.CommonBase;

public class Day17_PopupPage extends CommonBase
{
	private WebDriver driver;
	
	public Day17_PopupPage(WebDriver commonBaseDriver)
	{
		this.driver = commonBaseDriver;
	}
	
	public void handleChildWindow()
	{
		click(By.xpath("//a[text()='Click Here']"));
		// lay Main window
		String mainWindow = driver.getWindowHandle();
		// lay tap hop cac windows
		Set<String> windows = driver.getWindowHandles();
		for (String childWindow: windows)
		{
			if (!childWindow.equals(mainWindow))
			{
				driver.switchTo().window(childWindow);
				type(By.name("emailid"),"testEmail@gmail.com");
				click(By.name("btnLogin"));
				assertTrue(isElementDisplayed(By.xpath("//h2[text()='Access details to demo site.']")));
				driver.close();
				System.out.println("Child window has been closed");
			}
		}
		driver.switchTo().window(mainWindow);
		System.out.println("driver has been switched to main window");
		
	}
	
}
