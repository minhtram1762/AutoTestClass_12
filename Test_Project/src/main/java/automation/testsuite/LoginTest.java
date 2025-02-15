package automation.testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import automation.common.CommonBase;

public class LoginTest extends CommonBase {
	@BeforeMethod
	public void openBrowerTest()
	{
		driver = initBrowser("https://alada.vn/tai-khoan/dang-nhap.html");
	}
	@Test
	public void locateById()
	{
		WebElement textUsername = driver.findElement(By.id("txtLoginUsername"));
		System.out.println(textUsername);
		
		WebElement textPassword = driver.findElement(By.id("txtLoginPassword"));
		System.out.println("Text ID PW "+ textPassword);
	}
}
