package day1;

import org.testng.annotations.Test;

public class GoogleSearchTests extends TestBase {

    @Test
    public void test001Param() {
        String testData1 = "Portnov Computer School";
        GoogleMainPage mainPage = new GoogleMainPage(driver);
        GoogleResultsPage resultsPage = new GoogleResultsPage(driver);

        mainPage.navigateTo();
        mainPage.typeQuery(testData1);
        mainPage.submitSearch();
        resultsPage.verifyResultsPage();
    }

    @Test(dataProvider = "test1")
    public void test001(String queryText) {
        GoogleMainPage mainPage = new GoogleMainPage(driver);
        GoogleResultsPage resultsPage = new GoogleResultsPage(driver);

        mainPage.navigateTo();
        mainPage.typeQuery(queryText);
        mainPage.submitSearch();
        resultsPage.verifyResultsPage();
    }

    @Test
    public void test002() {
        String param1 = "portnov school";

        GoogleMainPage mainPage = new GoogleMainPage(driver);
        GoogleResultsPage resultsPage = new GoogleResultsPage(driver);

        mainPage.navigateTo();
        mainPage.typeQuery(param1);
        mainPage.submitSearch();
        resultsPage.verifyResultsPage();
    }
}
