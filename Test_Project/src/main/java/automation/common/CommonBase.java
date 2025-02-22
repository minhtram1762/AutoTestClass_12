package automation.common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CommonBase {
	public WebDriver driver;

	 // Đặt Chrome làm trình duyệt mặc định nếu không truyền vào
    public WebDriver initBrowser(String browserName, String URL) {
        if (browserName == null || browserName.isEmpty()) {
            browserName = "chrome"; // Mặc định chạy Chrome
        }

        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver");
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/driver/geckodriver");
            driver = new FirefoxDriver();
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browserName);
        }

        driver.get(URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;
    }

    // Overload phương thức để hỗ trợ các test case cũ
    public WebDriver initBrowser(String URL) {
        return initBrowser("chrome", URL); // Mặc định Chrome
    }
}