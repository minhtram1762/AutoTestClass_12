package automation.pageLocator;

import static org.testng.Assert.assertTrue;

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
	
	@FindBy(xpath="//a[text()='Chỉnh sửa thông tin']") WebElement buttonChinhSuaThongTin;
	@FindBy(id="txtpassword") WebElement textMatKhau;
	@FindBy(id="txtnewpass") WebElement textMatKhauMoi;
	@FindBy(id="txtrenewpass") WebElement textNhapLaiMatKhauMoi;
	@FindBy(xpath="//button[text()='Lưu mật khẩu mới']") WebElement buttonLuuMatKhau;
	
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
	
	public void ThongTinCaNhan()
	{
		avatar.click();
		buttonChinhSuaThongTin.click();
	}
	
	public WebElement getbuttonLuuMatKhau() 
	{
	    return buttonLuuMatKhau;
	}
	
	public void ChinhSuaThongTin(String matKhau, String matKhauMoi, String nhapLaiMatKhauMoi)
	{
		textMatKhau.sendKeys(matKhau);
		textMatKhauMoi.sendKeys(matKhauMoi);
		textNhapLaiMatKhauMoi.sendKeys(nhapLaiMatKhauMoi);
		buttonLuuMatKhau.click();
		
	}

}
