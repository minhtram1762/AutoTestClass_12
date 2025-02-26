package automation.pageLocator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Day14_RegisterPageFactory_Alada {

private WebDriver driver;
	
	// dung FindBy annotation thay cho findElement:
	@FindBy(id="txtFirstname") WebElement textHoTen;
	@FindBy(id="txtEmail") WebElement textEmail;
	@FindBy(id="txtCEmail") WebElement textNhapLaiEmail;
	@FindBy(id="txtPassword") WebElement textMatKhau;
	@FindBy(id="txtCPassword") WebElement textNhapLaiMatKhau;
	@FindBy(id="txtPhone") WebElement textDienThoai;
	@FindBy(xpath="//button[@class='btn_pink_sm fs16' and text()='ĐĂNG KÝ']") WebElement buttonDangKy;

	
	public Day14_RegisterPageFactory_Alada(WebDriver _driver)
	{
		this.driver = _driver;
		PageFactory.initElements(driver, this);
	}
	
	public void RegisterFunction(String hoTen, String email, String nhapLaiEmail, String matKhau, String nhapLaiMatKhau, String dienThoai)
	{
		textHoTen.sendKeys(hoTen);
		textEmail.sendKeys(email);
		textNhapLaiEmail.sendKeys(nhapLaiEmail);
		textMatKhau.sendKeys(matKhau);
		textNhapLaiMatKhau.sendKeys(nhapLaiMatKhau);
		textDienThoai.sendKeys(dienThoai);
		buttonDangKy.click();
	}
	
}
