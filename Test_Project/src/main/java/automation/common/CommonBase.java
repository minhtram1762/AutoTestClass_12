package automation.common;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CommonBase {
	public WebDriver driver;
	private int pageLoadTimeout = 40;

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
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        return driver;
    }

    // Overload phương thức để hỗ trợ các test case cũ
    public WebDriver initBrowser(String URL) {
        return initBrowser("chrome", URL); // Mặc định Chrome
    }
    
   public WebElement getElementPresentDOM (By locator)
   {
	   WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(pageLoadTimeout));
	   wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	   return driver.findElement(locator); 
   }
   
   public void click (By locator)
   {
	   WebElement element = getElementPresentDOM(locator);
	   WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(pageLoadTimeout));
	   wait.until(ExpectedConditions.elementToBeClickable(locator));
	   element.click();
   }
   
   public void type(By locator, String value)
   {
	   WebElement element = getElementPresentDOM(locator);
	   element.clear();
	   element.sendKeys(value);
   }
   
   public boolean isElementDisplayed(By locator)
   {
	   try {
	   WebElement element = getElementPresentDOM(locator); 
	   WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(pageLoadTimeout));
	   wait.until(ExpectedConditions.visibilityOf(element));
	   return element.isDisplayed(); 
	   }
   		catch (NoSuchElementException ex1)
   		{
   			return false;
   		}
   		catch (TimeoutException ex2)
	   {
   			return false;
	   }
   }
   
	   //cac ham dung javascript
	public void type_toElementByValueAttribute(By locator, String value)
	{
		try 
		{
			WebElement element = getElementPresentDOM(locator);  
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].value = '" + value + "'", element);
		}
		catch(StaleElementReferenceException ex)
		{
			type_toElementByValueAttribute(locator, value);
		}
	}
	
	public void scrollToElement(By locator) 
	{
		WebElement element = getElementPresentDOM(locator);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public void clickJavaScript(By locator)
	{
		WebElement element = getElementPresentDOM(locator);  
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}
	
}






