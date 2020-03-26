package day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class XpathTests {

    private WebDriver driver;

    @BeforeSuite
    public void setup() {
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\geckodriver.exe");
    }

    private void openBrowser() {
        driver = new FirefoxDriver();
    }

    @Test
    public void test0001() {
        openBrowser();
        driver.get("https://the-internet.herokuapp.com/login");

        String xpath = "/html/body/div[2]/div/div/form/div[1]/div/input";

        String relxPath = "//form/div[1]/div/input";
        String xPath01 = "//input[@name='username']";
        String xPath02 = "//input[@name='username'][@type='text']";
        String xPath03 = "//input[@name='username' and @type='text']";
        String xPath04 = "//input[@name='username' or @type='text']";
        String xPath05 = "//input[contains(@type,'word')]";
        String xPath06 = "//input[starts-with(@name,'user')]";
        String xPath07 = "//*[text()=' Login']";

        String xPath08 = "(//input[@type='text'])[last()]";

        String xPath09 = "(//*[contains(@id,'yui')])[20]";

        String xPath10 = "//*[@id='FirstName']/following::input[@type='text']";
        String xPath11 = "//*[@id='LastName']//preceding::input[@type='text']";
    }
}
