package automation.pageLocator;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import automation.common.CommonBase;

public class Day16_CSSystem_QuanLyKVLV extends CommonBase
{
	private WebDriver driver;
	
	public Day16_CSSystem_QuanLyKVLV (WebDriver driver)
	{
		if (driver == null) 
		{
			throw new RuntimeException("Driver không hợp lệ!");
		}
		this.driver = driver;
	}
	
	public void LoginFunction(String username, String pass)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
		
		type(By.id("email"), username);
		type(By.id("password"), pass);
		click(By.name("signin"));
	}
	
	public void addKLV (String tenKLV, String maKLV) 
	{
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		click(By.xpath("//a[@class='nav-link link-dark' and normalize-space()='Quản lý khu làm việc']"));
		click(By.xpath("//button[text()='Thêm mới']"));
		type(By.name("work_areas_code"), maKLV);
		type(By.name("name"), tenKLV);
		click(By.xpath("//button[text()='Lưu']"));
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Thêm']"))).click();
	}
	
	
}



