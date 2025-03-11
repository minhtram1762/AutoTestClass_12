package automation.testsuite;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;

public class Day17_btvn extends CommonBase
{
	@BeforeMethod
	public void openBrowser() 
	{
		driver = initBrowser("firefox","https://mediamart.vn/");
		if (driver == null) 
		{
		   throw new RuntimeException("WebDriver is null after initialization!");
		}
		System.out.println("Driver initialized in openBrowser: " + driver);
	}

	@Test (priority = 1)
	public void zalo () throws InterruptedException
	{
		driver.switchTo().frame(getElementPresentDOM(By.xpath("//iframe[contains(@src, 'page.widget.zalo.me')]")));
		click(By.xpath("//div[@class='za-chat__head-box']"));
		assertTrue(isElementDisplayed(By.xpath("//h1[text()='Xin chào!']")));		
	}

}
