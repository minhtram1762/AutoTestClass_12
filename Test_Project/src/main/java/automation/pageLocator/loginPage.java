package automation.pageLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage {

	private WebDriver driver;

	public loginPage(WebDriver _driver) 
	{
		this.driver = _driver;
	}
	
	public void LoginFunction(String email, String password)
		
	{
		WebElement emailTextbox = driver.findElement(By.id("txtLoginUsername"));
		//xoa gia tri mac dinh trong textbox email
		if(emailTextbox.isDisplayed());
		{
			emailTextbox.clear();
			//nhap admin@demo.com
			emailTextbox.sendKeys(email);
		}
		
		WebElement passwordTextbox = driver.findElement(By.id("txtLoginPassword"));
		if(passwordTextbox.isDisplayed())
		{
			passwordTextbox.clear();
			passwordTextbox.sendKeys(password);
		}
		
		//click button signin
		WebElement btnSignin = driver.findElement(By.xpath("//button[text()='ĐĂNG NHẬP' and @type='submit']"));
		if(btnSignin.isDisplayed())
		{
			btnSignin.click();
		}
	}

}
