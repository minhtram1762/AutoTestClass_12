package automation.testsuite;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Day17_btvn extends CommonBase
{
	
	@BeforeMethod
	public void openBrowser()
	{
		driver = initBrowser("chrome",CT_PageURL.URL_ALADA);
	}

	@Test 
	public void zalo () throws InterruptedException, IOException
	{
		driver.switchTo().frame(getElementPresentDOM(By.xpath("//iframe[contains(@src, 'page.widget.zalo.me')]")));
		
		click(By.xpath("//div[@class='za-chat__head-box']"));
		assertTrue(isElementDisplayed(By.xpath("//h1[text()='Xin chào!']")));		
	}

}
