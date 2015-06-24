package Framework;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Class that contains properties that are common for all tests. They are set in global.properties file.
 * 
 * @author kateryna.tsymbaliuk
 */
public class Driver {

    public static String browserName;

    private static Driver driver;
    public static WebDriver webDriver;

    private WebDriverWait wait;

	private Driver() {
        browserName = ProjectProperties.getInstance().getBrowserName().toUpperCase();
        startDriver();
        wait = new WebDriverWait(webDriver, 30);
	}

	public static Driver getInstance() {
		if (driver == null) {
            try {
                driver = new Driver();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
		return driver;
	}

    private void startDriver() {

        if (browserName.equals("SAFARI")){

            webDriver = new SafariDriver();

        } else if (browserName.equals("CHROME")){

            String path = System.getProperty("user.dir");

            File classpathRoot = new File(System.getProperty("user.dir"));
            File chromedriver = new File(classpathRoot, "src/chromedriver");
            System.setProperty("webdriver.chrome.driver", chromedriver.getAbsolutePath());
            webDriver = new ChromeDriver();

        } else {

            webDriver = new FirefoxDriver();
        }

        webDriver.manage().window().maximize();
        webDriver.get("https://testmunk.com");
    }

    public WebElement getElement(HashMap<String, String> locator, String variable) {
        locator.put("locator", locator.get("locator").replace("{}", variable));
        return getElement(locator);
    }

    public WebElement getElement(HashMap<String, String> locator) {
        By criteria = getCriteria(locator);
        WebElement element = null;
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(criteria));
            element = webDriver.findElement(criteria);
        } catch (ElementNotFoundException | TimeoutException e) {
            System.out.println("WARNING: Element with locator: " + locator.values().toString() + " wasn't found.");
        }
        return element;
    }

    public List<WebElement> getElements(HashMap<String, String> locator) {
        By criteria = getCriteria(locator);
        List<WebElement> elements = null;
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(criteria));
            elements = webDriver.findElements(criteria);
        } catch (ElementNotFoundException | TimeoutException e) {
            System.out.println("Element with locator: " + locator.values().toString() + " wasn't found");
        }
        return elements;
    }

    public WebElement getButton(HashMap<String, String> locator) {
        By criteria = getCriteria(locator);
        wait.until(ExpectedConditions.elementToBeClickable(criteria));
        return webDriver.findElement(criteria);
    }

    public WebElement getButton(HashMap<String, String> locator, int timeout) {
        By criteria = getCriteria(locator);
        WebElement element = null;
        try {
            wait.withTimeout(timeout, TimeUnit.SECONDS).until(ExpectedConditions.elementToBeClickable(criteria));
            element = webDriver.findElement(criteria);
        } catch (ElementNotFoundException | TimeoutException e) {
            System.out.println("Element with locator: " + locator.values().toString() + " wasn't found");
        }
        return element;
    }

    public WebElement getElement(HashMap<String, String> locator, int timeout) {
        By criteria = getCriteria(locator);
        WebElement element = null;
        try {
            wait.withTimeout(timeout, TimeUnit.SECONDS).until(ExpectedConditions.presenceOfElementLocated(criteria));
            element = webDriver.findElement(criteria);
        } catch (ElementNotFoundException | TimeoutException e) {
            System.out.println("Element with locator: " + locator.values().toString() + " wasn't found");
        }
        return element;
    }

    private By getCriteria(HashMap<String, String> locator) {
        switch (locator.get("criteria")) {
            case "cssSelector": return By.cssSelector(locator.get("locator"));
            case "xpath": return By.xpath(locator.get("locator"));
            default : return null;
        }
    }

    public static void stopDriver() {
        driver = null;
        webDriver.quit();
    }

}
