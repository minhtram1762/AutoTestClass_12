package automation.testsuite;

import static org.testng.Assert.*;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;

public class Day16_btvnAlert_2 extends CommonBase
{
	@BeforeMethod
	public void openBrowser()
	{
		driver = initBrowser("firefox",CT_PageURL.URL_SEL_Practice);
	}	

	@Test 
	public void pressOKButton()
	{
		click(By.xpath("//button[text()='Try it']"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.alertIsPresent());
		
		String actualMessage = driver.switchTo().alert().getText();
		String expectedMessage = "Welcome to Selenium WebDriver Tutorials";
		assertEquals(actualMessage, expectedMessage);
		driver.switchTo().alert().accept();
		assertTrue(isElementDisplayed(By.xpath("//h3[normalize-space()='Alert Demo']")));
	}

}
