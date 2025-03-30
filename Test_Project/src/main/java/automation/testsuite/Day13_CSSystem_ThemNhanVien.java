package automation.testsuite;

	import static org.testng.Assert.assertTrue;

	import org.openqa.selenium.By;
	import org.testng.annotations.*;

	import automation.common.CommonBase;
	import automation.constant.CT_PageURL;
	import automation.pageLocator.LoginPage_CSSystem;

	public class Day13_CSSystem_ThemNhanVien extends CommonBase 
	{
	    @BeforeMethod
	    public void openBrowser()
		{
			driver = initBrowser("firefox",CT_PageURL.URL_CSSYSTEM);
		}
		
		@Test(priority = 1)
		public void loginSuccessfully()
		{
			LoginPage_CSSystem _login = new LoginPage_CSSystem(driver);
			_login.LoginFunction("admin@gmail.com", "12345678");
			assertTrue(driver.findElement(By.xpath("//p[text()='Quản lý người dùng']")).isDisplayed());
		}

		@Test
		public void themNhanVien() throws InterruptedException
		{
			LoginPage_CSSystem _login = new LoginPage_CSSystem(driver);
			_login.LoginFunction("admin@gmail.com", "12345678");
			assertTrue(driver.findElement(By.xpath("//p[text()='Quản lý người dùng']")).isDisplayed());
			_login.chucNangThemNhanVien("LeThiAnhTest", "anhletest@gmail.com", "777-888-999", "Quản Lý", "2", "1", "555666");
			assertTrue(driver.findElement(By.xpath("//p[text()='Quản lý người dùng']")).isDisplayed());
		}
}
