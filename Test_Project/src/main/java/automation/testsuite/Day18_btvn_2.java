package automation.testsuite;

import automation.common.CommonBase;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

public class Day18_btvn_2 extends CommonBase
{
	@BeforeMethod
	public void openBrowser()
	{
		driver = initBrowser("https://bepantoan.vn/");
	}

	@Test 
	public void lienHeMessenger()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement messengerLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@href='https://m.me/1463299120624512'])[1]")));
        String originalWindow = driver.getWindowHandle();
        messengerLink.click();

        // Chờ và chuyển sang tab mới
        Set<String> windowHandles = driver.getWindowHandles();
        for (String window : windowHandles) {
            if (!window.equals(originalWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }

        // Kiểm tra URL của trang mới
        String expectedUrl = "https://www.messenger.com/login.php?next=https%3A%2F%2Fwww.messenger.com%2Ft%2F1463299120624512%2F%3Fmessaging_source%3Dsource%253Apages%253Amessage_shortlink%26source_id%3D1441792%26recurring_notification%3D0";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "Zalo link navigation failed!");
        
	}
}
