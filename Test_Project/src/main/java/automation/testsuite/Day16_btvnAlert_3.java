package automation.testsuite;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;

public class Day16_btvnAlert_3 extends CommonBase
{
	@BeforeMethod
	public void openBrowser()
	{
		driver = initBrowser("firefox",CT_PageURL.URL_GURU99_delete);
	}	

	@Test (priority = 1)
	public void DeleteCustomer()
	{
		driver.findElement(By.name("cusid")).sendKeys("123456");
        driver.findElement(By.name("submit")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        
		Alert alert1 = driver.switchTo().alert();
        assertEquals(alert1.getText(), "Do you really want to delete this Customer?", "Alert 1 message không đúng!");
        alert1.accept();
        
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert2 = driver.switchTo().alert();
        String alertMessage = alert2.getText();
        assertEquals(alertMessage, "Customer Successfully Delete!", "Alert 2 message không đúng!");
        alert2.accept();

        assertEquals(driver.getCurrentUrl(), "https://demo.guru99.com/test/delete_customer.php", "Không quay về trang gốc!");
    }
}

