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
	@Test
	public void locateByName()
	{
		WebElement textUsername = driver.findElement(By.name("txtLoginUsername"));
		System.out.println(textUsername);
		
		WebElement textPassword = driver.findElement(By.name("txtLoginPassword"));
		System.out.println("Text NAME PW "+textPassword);
	}
	@Test
	public void locateByClassName()
	{
		WebElement btnFacebook = driver.findElement(By.className("btn_face"));
		System.out.println("Button Facebook element is: "+btnFacebook);

	}
	
	@Test
	public void locateByLink()
	{
		WebElement linkForgotPW = driver.findElement(By.linkText("Quên mật khẩu?"));
		System.out.println("Link forgot PW: "+linkForgotPW);

		WebElement linkGiangVien = driver.findElement(By.partialLinkText("giảng viên"));
		System.out.println("Link login for trainer is: "+linkGiangVien);

	}
	@Test
	public void locateByTagName() throws InterruptedException
	{
		Thread.sleep(3000);
		WebElement textInput = driver.findElement(By.tagName("input"));
		System.out.println("Input tag Name : "+textInput);
	}
}