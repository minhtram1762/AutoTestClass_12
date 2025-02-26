package automation.pageLocator;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class LoginPage_CSSystem {

	private WebDriver driver;

	@FindBy(xpath = "//button[text()='Thêm mới']") WebElement buttonThemMoi;
	@FindBy(name = "username") WebElement textHoTen;
	@FindBy(name = "email") WebElement textEmail;
	@FindBy(name = "phone_number") WebElement textSDT;
	@FindBy(id = "select_department_id") WebElement dropDownDepartment;
	@FindBy(id = "select_role_id") WebElement dropDownRole;
	@FindBy(id = "select_workarea_id") WebElement dropDownWorkArea;
	@FindBy(name = "code_user") WebElement textMaNguoiDung;
	@FindBy(xpath = "//button[text()='Lưu']") WebElement buttonLuu;
	@FindBy(xpath = "//button[text()='Thêm']") WebElement buttonThem;

	public LoginPage_CSSystem(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void LoginFunction(String email, String password)
	{
		WebElement emailTextbox = driver.findElement(By.id("email"));
		emailTextbox.sendKeys(email);
		
		WebElement passwordTextbox = driver.findElement(By.id("password"));
		passwordTextbox.sendKeys(password);
		
		WebElement btnSignin = driver.findElement(By.xpath("//button[text()='Đăng nhập' and @type='submit']"));
		btnSignin.click();
	}

	public void LogoutFunction()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    try {
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("toast-title")));
	    } catch (Exception e) {
	        System.out.println("No toast message to wait for.");
	    }

	    WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("dropdownMenuLink")));
	    dropdown.click();

		WebElement btnLogout = driver.findElement(By.xpath("//button[@class='dropdown-item' and text()='Đăng xuất']"));
		btnLogout.click();
		
		WebElement btnLogout2 = driver.findElement(By.xpath("//button[text()='Đăng xuất' and @type='submit']"));
		btnLogout2.click();
	}

	public void chucNangThemNhanVien(String hoTen, String email, String soDienThoai, String phongBan, String role, String KVLV, String maNguoiDung) throws InterruptedException
	{
		buttonThemMoi.click();
		textHoTen.sendKeys(hoTen);
		textEmail.sendKeys(email);
		textSDT.sendKeys(soDienThoai);
		Select selectPhongBan = new Select(dropDownDepartment);
		selectPhongBan.selectByContainsVisibleText(phongBan);
		Thread.sleep(3000);
		Select selectChucDanh = new Select(dropDownRole);
		selectChucDanh.selectByValue(role);
		Thread.sleep(3000);
		Select selectKVLV = new Select(dropDownWorkArea);
		selectKVLV.selectByValue(KVLV);
		Thread.sleep(3000);
		textMaNguoiDung.sendKeys(maNguoiDung);
		buttonLuu.click();
		buttonThem.click();
		Thread.sleep(3000);
	}
	
	
}
