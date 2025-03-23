package automation.testsuite;

import automation.common.CommonBase;

import static org.testng.Assert.assertTrue;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

public class Day18_BepTu extends CommonBase
{
	@BeforeMethod
	public void openBrowser()
	{
		driver = initBrowser("firefox","https://bepantoan.vn/");
	}

	@Test 
	public void testBepTu_Bosch()
	{
		click(By.xpath("//a[text()=' Bếp Từ ']"));
		click(By.xpath("(//a[contains(@href,'bep-tu/bosch')])[1]"));
		if(isElementDisplayed(By.xpath("//div[contains(@class,'product-list')]/a//h4"))==true)
		{
		List<WebElement> listProduct = driver.findElements(By.xpath("//div[contains(@class,'product-list')]/a//h4"));
	for (WebElement product : listProduct)
		{
			String actualProductName = product.getText().toUpperCase();
			System.out.println("Ten san pham tren man hinh: " + actualProductName);
			assertTrue(actualProductName.contains("BOSCH"));
	}
	}
		else {
			System.out.println("Test failed");
			assertTrue(isElementDisplayed(By.xpath("//div[contains(@class,'product-list')]/a/h4")));
		}
	}
}
