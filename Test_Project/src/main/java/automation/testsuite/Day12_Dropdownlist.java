package automation.testsuite;

	import org.openqa.selenium.By;
	import org.openqa.selenium.support.ui.Select;

	import org.testng.annotations.*;

	import automation.common.CommonBase;
	import automation.constant.CT_PageURL;

	public class Day12_Dropdownlist extends CommonBase 
	{

		@BeforeMethod
		public void openBrowser()
		{
			driver = initBrowser(CT_PageURL.URL_CODESTAR);
		}
		
		@Test
		public void chooseAWSOption()
		{
			Select dropdownCourse = new Select(driver.findElement(By.id("product_categories_filter")));
			System.out.println("So lua chon cua dropdown list la: "+dropdownCourse.getOptions().size());
			dropdownCourse.selectByContainsVisibleText("AWS");
			String textAfterSelect = dropdownCourse.getFirstSelectedOption().getText();
			System.out.println("Text is: "+textAfterSelect);
			System.out.println("Is multiple: "+dropdownCourse.isMultiple());
		}
		
}