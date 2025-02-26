package automation.pageLocator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Day14_LoginPageFactory {

	private WebDriver driver;
	
	// dung FindBy annotation thay cho findElement:
	@FindBy(id="txtLoginUsername") WebElement textEmail;
	@FindBy(id="txtLoginPassword") WebElement textPassword;
	@FindBy(xpath="//button[text()='ĐĂNG NHẬP' and @type='submit']") WebElement buttonLogin;
	@FindBy(xpath="//div[@class='avatar2']/child::i") WebElement avatar;
	@FindBy(xpath="//a[text()='Thoát']") WebElement buttonLogout;
	
	public Day14_LoginPageFactory(WebDriver _driver)
	{
		this.driver = _driver;
		PageFactory.initElements(driver, this);
	}
	
	public void LoginFunction(String email, String password)
	{
		textEmail.clear();
		textEmail.sendKeys(email);
		textPassword.clear();
		textPassword.sendKeys(password);
		buttonLogin.click();
	}
	
	public void LogoutFunction()
	{
		avatar.click();
		buttonLogout.click();
	}
	
	
}
