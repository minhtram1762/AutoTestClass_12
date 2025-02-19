package automation.testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;


public class Day12_btvn extends CommonBase 
{

	@BeforeMethod
	public void openBrowser()
	{
		driver = initBrowser(CT_PageURL.URL_GLOBALQA);
	}
	
	@Test
	public void chooseAWSOption()
	{
		Select dropdownCountry = new Select(driver.findElement(By.xpath("//div[@rel-title='Select Country']/p/select")));
		System.out.println("So lua chon cua dropdown list la: "+dropdownCountry.getOptions().size());
		dropdownCountry.selectByContainsVisibleText("V");
		String textAfterSelect = dropdownCountry.getFirstSelectedOption().getText();
		System.out.println("Ten quoc gia la: "+textAfterSelect);
		System.out.println("Is multiple: "+dropdownCountry.isMultiple());
	}
	
}


