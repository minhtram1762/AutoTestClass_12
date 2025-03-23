package automation.testsuite;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

public class Day18_btvn_1 extends CommonBase
{
	@Parameters("browserTestNG") 
	@BeforeMethod
	public void openBrowser(String browserTestNG) 
	{
		driver = initBrowser(browserTestNG,"https://dienmaynhapkhaugiare.com.vn/");
	}

	@Test 
	public void lienHeZalo()
	{
		WebElement zaloLink = driver.findElement(By.xpath("//div[@id='zalo-vr']"));
        String originalWindow = driver.getWindowHandle();
        zaloLink.click();

        // Chờ và chuyển sang tab mới
        Set<String> windowHandles = driver.getWindowHandles();
        for (String window : windowHandles) {
            if (!window.equals(originalWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }

        // Kiểm tra URL của trang mới
        String expectedUrl = "https://id.zalo.me/account?continue=http%3A%2F%2Fzalo%2Eme%2F0988169282";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "Zalo link navigation failed!");
    }

}
