import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjectWikipedia.SearchResultPage;
import pageobjectWikipedia.WikipediaMainPage;

import java.util.concurrent.TimeUnit;

public class WikipediaTestCase {

    private WebDriver driver;

    @Before
    public void driverSetUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://ru.wikipedia.org/wiki/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void testLabelJava() {
        final WikipediaMainPage wikiMain = new WikipediaMainPage(driver);
        wikiMain.typeSearchedText("Java");
        final SearchResultPage searchResultPage = wikiMain.clickSearchButton();
        Assert.assertTrue("The label is not correct!", searchResultPage.verifyLabel("Java"));
    }

    @After
    public void driverClose() {
        driver.close();
    }

}

