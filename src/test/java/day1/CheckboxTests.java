package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;

public class CheckboxTests {

    WebDriver driver;
    List<WebElement> listOfCheckboxes;
    WebElement checkbox1;
    WebElement checkbox2;

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

    //TODO: find a way of checking state by a different way
    @Test
    public void test002() {

    }

    @Test
    public void test001() {
        openBrowser();
        navigateToMainPage();
        findAndVerifyCheckBoxes();
        checkForCheckboxStatus();

        //TODO: interacting with checkboxes

        //TODO: check for changes states of the elements
    }

    private void checkForCheckboxStatus() {
        String isFirstChecked = checkbox1.getAttribute("checked");
        String isSecondChecked = checkbox2.getAttribute("checked");

        Assert.assertNull(isFirstChecked);
        String expectedSecondChecked = "true";
        Assert.assertEquals(expectedSecondChecked, isSecondChecked);
        //TODO: check the visibility of the elements
    }

    private void findAndVerifyCheckBoxes() {
        listOfCheckboxes = driver.findElements(By.tagName("input"));
        checkbox1 = listOfCheckboxes.get(0);
        checkbox2 = listOfCheckboxes.get(1);
    }

    private void navigateToMainPage() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
    }
}
