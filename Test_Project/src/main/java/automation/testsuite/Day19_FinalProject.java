package automation.testsuite;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.pageLocator.Day16_CSSystem_QuanLyKVLV;

public class Day19_FinalProject extends CommonBase
{
	String tenKLV = "KLV Tram Test";
	
	@BeforeMethod
	public void openBrowser()
	{
		driver = initBrowser("firefox",CT_PageURL.URL_CSSYSTEM);
	}
		
	@Test(priority = 1)
	public void addKLV_successfully()
	{
		Day16_CSSystem_QuanLyKVLV crm = new Day16_CSSystem_QuanLyKVLV(driver);
	    crm.LoginFunction("admin@gmail.com", "12345678");
	    crm.addKLV("090320251640", tenKLV);
		assertTrue(driver.findElement(By.xpath("//a[@class='navbar-brand' and normalize-space()='Quản lý khu làm việc']")).isDisplayed());
	}
	
	@Test(priority = 2)
	public void addKLV_unsuccessfully_TH1() //sai Ma KLV: nhap ky tu dac biet 'dau cach'
	{
		Day16_CSSystem_QuanLyKVLV crm = new Day16_CSSystem_QuanLyKVLV(driver);
	    crm.LoginFunction("admin@gmail.com", "12345678");
	    crm.addKLV_unsuccessfully("090320251640 incorrect", tenKLV);
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	    WebElement flashMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Dữ liệu nhập vào sai định dạng')]")));

	    String messageText = flashMessage.getText();
	    System.out.println("Error message: " + messageText);

	    assertTrue(messageText.contains("Dữ liệu nhập vào sai định dạng"), "Error message không đúng hoặc không xuất hiện!");
	}
	
	@Test(priority = 3)
	public void addKLV_unsuccessfully_TH2() //sai Ten KLV: nhap ky tu dac biet
	{
		Day16_CSSystem_QuanLyKVLV crm = new Day16_CSSystem_QuanLyKVLV(driver);
	    crm.LoginFunction("admin@gmail.com", "12345678");
	    crm.addKLV_unsuccessfully("090320251640", "KLV@£$%^");
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	    WebElement flashMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Dữ liệu nhập vào sai định dạng')]")));

	    String messageText = flashMessage.getText();
	    System.out.println("Error message: " + messageText);

	    assertTrue(messageText.contains("Dữ liệu nhập vào sai định dạng"), "Error message không đúng hoặc không xuất hiện!");
	}
	
	@Test(priority = 4)
	public void addKLV_unsuccessfully_TH3() //bo trong Ma KLV va Ten KLV
	{
		Day16_CSSystem_QuanLyKVLV crm = new Day16_CSSystem_QuanLyKVLV(driver);
	    crm.LoginFunction("admin@gmail.com", "12345678");
	    crm.addKLV_unsuccessfully("", "");
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	    WebElement flashMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Không được để trống trường này')]")));

	    String messageText = flashMessage.getText();
	    System.out.println("Error message: " + messageText);

	    assertTrue(messageText.contains("Không được để trống trường này"), "Error message không đúng hoặc không xuất hiện!");
	}
	
	@Test(priority = 5)
	public void searchKLV_unsuccessfully() //khong tim thay ket qua
	{
		Day16_CSSystem_QuanLyKVLV crm = new Day16_CSSystem_QuanLyKVLV(driver);
	    crm.LoginFunction("admin@gmail.com", "12345678");
	    crm.searchKLV("123443333");
		assertTrue(isElementDisplayed(By.xpath("//h4[text()='Không tìm thấy kết quả']")));
	}
	
	@Test(priority = 6)
	public void editKLV_successfully()// khong sua gi ca va bam Luu
	{
		Day16_CSSystem_QuanLyKVLV crm = new Day16_CSSystem_QuanLyKVLV(driver);
	    crm.LoginFunction("admin@gmail.com", "12345678");	
		crm.editKLV("090320251640",tenKLV);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	    WebElement flashMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
	            By.xpath("//*[contains(text(), 'Chỉnh sửa thông tin khu vực thành công')]")));

	    String messageText = flashMessage.getText();
	    System.out.println("Flash message: " + messageText);
	    assertTrue(messageText.contains("Chỉnh sửa thông tin khu vực thành công"), "Flash message không đúng hoặc không xuất hiện!");
	}
	
	@Test(priority = 7)
	public void editKLV_successfully_2()// chi sua Ma KLV
	{
		Day16_CSSystem_QuanLyKVLV crm = new Day16_CSSystem_QuanLyKVLV(driver);
	    crm.LoginFunction("admin@gmail.com", "12345678");	
		crm.editKLV("090320251640edit",tenKLV);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	    WebElement flashMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
	            By.xpath("//*[contains(text(), 'Chỉnh sửa thông tin khu vực thành công')]")));

	    String messageText = flashMessage.getText();
	    System.out.println("Flash message: " + messageText);
	    assertTrue(messageText.contains("Chỉnh sửa thông tin khu vực thành công"), "Flash message không đúng hoặc không xuất hiện!");
	}
	
	@Test(priority = 8)
	public void editKLV_successfully_3()// chi sua Ten KLV
	{
		Day16_CSSystem_QuanLyKVLV crm = new Day16_CSSystem_QuanLyKVLV(driver);
	    crm.LoginFunction("admin@gmail.com", "12345678");	
		crm.editKLV("090320251640","KLV Tram Test 2");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	    WebElement flashMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
	            By.xpath("//*[contains(text(), 'Chỉnh sửa thông tin khu vực thành công')]")));

	    String messageText = flashMessage.getText();
	    System.out.println("Flash message: " + messageText);
	    assertTrue(messageText.contains("Chỉnh sửa thông tin khu vực thành công"), "Flash message không đúng hoặc không xuất hiện!");
	}
	
	@Test(priority = 9)
	public void deleteKLV_successfully()
	{
		Day16_CSSystem_QuanLyKVLV crm = new Day16_CSSystem_QuanLyKVLV(driver);
	    crm.LoginFunction("admin@gmail.com", "12345678");	
		crm.deleteKLV(tenKLV);
		String actualMessage = driver.switchTo().alert().getText();
		String expectedMessage = "Bạn có thực sự muốn xóa khu vực này";
		assertEquals(actualMessage, expectedMessage);
		driver.switchTo().alert().accept();
		assertTrue(isElementDisplayed(By.xpath("//h4[text()='Không tìm thấy kết quả']")));
	}
}
