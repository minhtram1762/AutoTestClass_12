package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;

public class Day17_iFrame extends CommonBase
{
	@BeforeMethod
	public void openBrowser() 
	{
		driver = initBrowser("firefox",CT_PageURL.URL_CODESTAR_2);
		if (driver == null) 
		{
		   throw new RuntimeException("WebDriver is null after initialization!");
		}
		System.out.println("Driver initialized in openBrowser: " + driver);
	}

	@Test (priority = 1)
	public void dangKyNhanTuVan() throws InterruptedException
	{
		scrollToElement(By.xpath("//h2[contains(text(), 'Đăng kí nhận tư vấn lộ trình')]"));
		driver.switchTo().frame(getElementPresentDOM(By.xpath("(//iframe[@title= 'Khách hàng']) [1]")));
		type(By.id("name"),"Auto test name");
		type(By.id("phone_number"),"098888777");
		click(By.xpath("//button[normalize-space()='Gửi ngay']"));
		assertTrue(isElementDisplayed(By.xpath("//button[normalize-space()='Gửi ngay']")));		
	}
	
	@Test (priority = 2)
	public void findIndexIframe()
	{
		//tim tong so tat ca iframe
		int soIframe = driver.findElements(By.tagName("iframe")).size();
		System.out.println("so iframe la: "+soIframe);
		for(int i=0; i < soIframe; i++)
		{
			driver.switchTo().frame(i);
			if(driver.findElements(By.id("name")).size()>0)
			{
				System.out.println("Frame chua the Ho va Ten o vi tri thu: " +i);
			}
			driver.switchTo().defaultContent();
		}
	}
}









