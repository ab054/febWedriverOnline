package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public class TestBase {

    WebDriver driver;

    public static WebElement waitForElement(WebDriver driver, By locator, int numberOfSeconds) {
        WebElement element = new WebDriverWait(driver, numberOfSeconds)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element;
    }

    @BeforeMethod
    public void setupTest() {
        openBrowser();
    }

    @DataProvider(name = "test1")
    public Object[][] createData1() {
        return new Object[][]{
                {"portnov computer school"},
                {"portnov computer"},
        };
    }

    @BeforeClass
    public void testSetup() {
        System.out.println("test setup");
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\geckodriver.exe");
    }

    @AfterMethod
    public void suitEnd() {
        driver.quit();
    }

    public void openBrowser() {
        driver = new FirefoxDriver();
    }

    public void sleep() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
