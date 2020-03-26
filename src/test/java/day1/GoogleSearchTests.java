package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GoogleSearchTests {

    WebDriver driver;

    @BeforeClass
    public void testSetup() {
        System.out.println("test setup");
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\geckodriver.exe");
    }

    @AfterMethod
    public void suitEnd() {
        driver.quit();
    }


    @Parameters({"queryForSearch"})
    @Test
    public void test001Param(String param1) {
        openBrowser();
        navigateToMainPage();
        typeQuery(param1);
        submitSearch();
        verifyResultsPage();
    }

    @Test
    public void test001() {
        String param1 = "portnov computer school";

        openBrowser();
        navigateToMainPage();
        typeQuery(param1);
        submitSearch();
        verifyResultsPage();
    }

    @Test
    public void test002() {
        String param1 = "portnov school";

        openBrowser();
        navigateToMainPage();
        typeQuery(param1);
        submitSearch();
        verifyResultsPage();
    }

    private void verifyResultsPage() {
        WebElement element = waitForElement(By.id("result-stats"), 10);
        String elementText = element.getText();
        String[] splittedText = elementText.split(" ");
        String numberOfResults = splittedText[1].replace(",", "");
        int numberOfResINT = Integer.parseInt(numberOfResults);
        boolean displayed = element.isDisplayed();
        Assert.assertTrue(displayed);
        Assert.assertTrue(numberOfResINT > 100);
    }

    public WebElement waitForElement(By locator, int numberOfSeconds) {
        WebElement element = new WebDriverWait(driver, numberOfSeconds)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element;
    }

    public void sleep() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void submitSearch() {
        driver.findElement(By.cssSelector("#tsf > div:nth-child(2) > div.A8SBwf > div.RNNXgb > div > div.a4bIc > input")).submit();
    }

    private void typeQuery(String param1) {
        String locatorCSS = "#tsf > div:nth-child(2) > div.A8SBwf > div.RNNXgb > div > div.a4bIc > input";
        WebElement element = driver.findElement(By.cssSelector(locatorCSS));
        element.sendKeys(param1);
    }

    private void navigateToMainPage() {
        String url = "https://www.google.com/";
        driver.get(url);
    }

    private void openBrowser() {
        driver = new FirefoxDriver();
    }
}
