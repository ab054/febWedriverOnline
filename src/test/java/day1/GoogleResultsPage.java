package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static day1.TestBase.waitForElement;

public class GoogleResultsPage {

    WebDriver driver;

    By resultsStatsLabel = By.id("result-stats");

    public GoogleResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyResultsPage() {
        WebElement element = waitForElement(driver, resultsStatsLabel, 10);
        String elementText = element.getText();
        String[] splittedText = elementText.split(" ");
        String numberOfResults = splittedText[1].replace(",", "");
        int numberOfResINT = Integer.parseInt(numberOfResults);
        boolean displayed = element.isDisplayed();
        Assert.assertTrue(displayed);
        Assert.assertTrue(numberOfResINT > 100);
    }


}
