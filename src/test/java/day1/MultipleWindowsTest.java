package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindowsTest {

    private WebDriver driver;
    private Set<String> windowHandles;
    private String handle1;
    private String handle2;

    @BeforeSuite
    public void setup() {
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\geckodriver.exe");
    }

    @AfterSuite
    public void suitEnd() {
        driver.quit();
    }

    private void openBrowser() {
        driver = new FirefoxDriver();
    }

    @Test
    public void test001() {
        openBrowser();
        navigateToMainPage();
        clickOnLink();
        verifyAmountOfWindows();
        verifyNewWindow();

        //TODO: add more user actions, link clicks, window switching etc.
    }

    private void verifyNewWindow() {
        driver.switchTo().window(handle2);
        String secondWindowTitle = driver.getTitle();
        Assert.assertEquals("New Window", secondWindowTitle);
        String pageSource = driver.getPageSource();
        boolean ifContainsExpectedText = pageSource.contains("New Window");
        Assert.assertEquals(ifContainsExpectedText, true);
    }

    private void verifyAmountOfWindows() {
        windowHandles = driver.getWindowHandles();
        String assertionErrorMessage = "Amount of windows was different from expected";
        Assert.assertTrue(windowHandles.size() == 2, assertionErrorMessage);
        handle1 = (String) windowHandles.toArray()[0];
        handle2 = (String) windowHandles.toArray()[1];
    }

    private void clickOnLink() {
        driver.findElement(By.linkText("Click Here")).click();
        //TODO: we don't want to use Thread.sleep()
        sleep();
    }

    private void navigateToMainPage() {
        driver.get("https://the-internet.herokuapp.com/windows");
    }

    public void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
