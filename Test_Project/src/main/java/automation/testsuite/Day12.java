package automation.testsuite;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;

public class Day12 extends CommonBase 
{

	@BeforeMethod
	public void openBrowser()
	{
		driver = initBrowser(CT_PageURL.URL_DEMOQA);
	}
	
	@Test
	public void clickOnCheckBox()
	{
		WebElement checkboxSport = driver.findElement(By.id("hobbies-checkbox-1"));
		if(checkboxSport.isSelected()==false)
		{
			driver.findElement(By.xpath("//label[text()='Sports']")).click();
			System.out.println("Checkbox Sports has clicked");
		}
		
		WebElement checkboxReading = driver.findElement(By.id("hobbies-checkbox-2"));
		if(checkboxReading.isSelected()==false)
		{
			driver.findElement(By.xpath("//label[text()='Reading']")).click();
			System.out.println("Checkbox Reading has clicked");
		}
	}
	
	@Test
	public void clickMultiple()
	{
		List<WebElement> listCheckbox = driver.findElements(By.xpath("//input[@type='checkbox']/following-sibling::label"));
				for (WebElement checkbox : listCheckbox)
				{
					if(checkbox.isSelected()==false)
					{
						checkbox.click();
					}
				}
	}
	
	@Test
	public void clickRadioButton()
	{
		WebElement radioMale = driver.findElement(By.xpath("//label[text()='Male']"));
		//1. Kiem tra gia tri mac dinh cua radioMale la chua click
		boolean isClickedMale = radioMale.isSelected();
		System.out.println("Radio Male is clicked: "+isClickedMale);
		if(radioMale.isEnabled()==true)
		{
			radioMale.click();
		
		}
	}
	
	
	
	
}
