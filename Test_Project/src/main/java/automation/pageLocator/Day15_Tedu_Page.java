package automation.pageLocator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.JavascriptExecutor;


public class Day15_Tedu_Page {
	private WebDriver driver;
	@FindBy(id="UserName") WebElement textUserName;
	@FindBy(id="Password") WebElement textPassword;
	@FindBy(xpath="//button[text()='Đăng nhập']") WebElement btnLogin;
	@FindBy(id="my_account") WebElement btnMyAccount;
	@FindBy(xpath="//a[@title='Đổi mật khẩu']") WebElement btnChangePass;
	
	@FindBy(id="OldPassword") WebElement textOldPassword;
	@FindBy(id="NewPassword") WebElement textNewPassword;
	@FindBy(id="ConfirmNewPassword") WebElement textConfirmPass;
	@FindBy(xpath="//input[@value='Cập nhật']") WebElement btnUpdatePass;
	
	@FindBy(xpath="//button[@id='onesignal-slidedown-cancel-button']") WebElement btnCancelPopup;
	@FindBy(xpath="//button[@type='submit']") WebElement btnSearch;
	@FindBy(xpath="//input[@name='keyword']") WebElement textTimKiem;

	public Day15_Tedu_Page(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void loginFunction(String username, String password)
	{
		textUserName.sendKeys(username);	
		textPassword.sendKeys(password);
		btnLogin.click();
	}
	
	public void updatePass(String oldPass, String newPass) throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", btnMyAccount);
		Thread.sleep(3000);
		js.executeScript("arguments[0].click();", btnChangePass);
		Thread.sleep(3000);
		textOldPassword.sendKeys(oldPass);
		textNewPassword.sendKeys(newPass);
		textConfirmPass.sendKeys(newPass);
		btnUpdatePass.click();
	}
	
	public void searchKhoaHoc(String courseName) throws InterruptedException
	{
		btnCancelPopup.click();
		Thread.sleep(3000);
		textTimKiem.sendKeys(courseName);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", btnSearch);
	}
	
	
}
