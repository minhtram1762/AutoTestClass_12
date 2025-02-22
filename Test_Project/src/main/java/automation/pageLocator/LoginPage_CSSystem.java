package automation.pageLocator;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class LoginPage_CSSystem {

	private WebDriver driver;

	public LoginPage_CSSystem(WebDriver _driver) 
	{
		this.driver = _driver;
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
}
