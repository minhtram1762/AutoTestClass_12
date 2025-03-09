package automation.testsuite;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;

public class Day16_Alert_Test extends CommonBase
{
	@BeforeMethod
	public void openBrowser()
	{
		driver = initBrowser("firefox",CT_PageURL.URL_ALERTDEMO);
	}	

	@Test (priority = 1)
	public void pressOKButton()
	{
		click(By.xpath("//a[text()='Alert with Textbox ']"));
		click(By.xpath("//button[@class='btn btn-info']"));
		//kiem tra message cua alert hien thi dung 
		String actualMessage = driver.switchTo().alert().getText();
		String expectedMessage = "Please enter your name";
		assertEquals(actualMessage, expectedMessage);
		//Nhap "Class 12" va click Ok => hien thi text "Hello Class 12 How are you today"
		driver.switchTo().alert().sendKeys("Class 12");
		driver.switchTo().alert().accept();
		WebElement elementResult = getElementPresentDOM(By.id("demo1"));
		String actualText = elementResult.getText();
		String expectedText = "Hello Class 12 How are you today";
		assertEquals(actualText, expectedText);
	}
	
	@Test (priority = 2)
	public void pressCancelButton()
	{
		click(By.xpath("//a[text()='Alert with Textbox ']"));
		click(By.xpath("//button[@class='btn btn-info']"));
		//kiem tra message cua alert hien thi dung 
		String actualMessage = driver.switchTo().alert().getText();
		String expectedMessage = "Please enter your name";
		assertEquals(actualMessage, expectedMessage);
		//Nhap "Class 12" va click Ok => hien thi text "Hello Class 12 How are you today"
		driver.switchTo().alert().sendKeys("Class 12");
		driver.switchTo().alert().dismiss();
		assertFalse(isElementDisplayed(By.id("demo1")));
	}
	
	
	
}
