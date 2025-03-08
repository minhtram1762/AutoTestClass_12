package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import automation.common.CommonBase;

public class Day15_DatePicker_input extends CommonBase
{
	@BeforeMethod
	public void openBrowser()
	{
		driver = initBrowser("firefox","https://demo.guru99.com/test/");
	}	

	@Test
	public void typeToDatePicker()
	{
		WebElement datePickerBDay = driver.findElement(By.name("bdaytime"));
		//remove thuoc tinh Readonly neu co trong the input
		//js.executeScript("arguments[0].removeAttribute('readonly','readonly');", datePickerBDay);
		
		datePickerBDay.sendKeys("12022020 0110 AM");
		//datePickerBDay.sendKeys(Keys.TAB);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		assertTrue(driver.findElement(By.xpath("//div[text()='Your Birth Date is 2020-02-12']")).isDisplayed());
		assertTrue(driver.findElement(By.xpath("//div[text()='Your Birth Time is 01:10']")).isDisplayed());
	}
}
