package day1;

import org.openqa.selenium.WebDriver;

public class Gpo {

    public final GoogleMainPage mainPage;
    public final GoogleResultsPage resultsPage;

    public Gpo(WebDriver driver) {
        mainPage = new GoogleMainPage(driver);
        resultsPage = new GoogleResultsPage(driver);
    }
}
