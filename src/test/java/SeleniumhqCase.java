import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjectsSelenium.DownloadsPage;
import pageobjectsSelenium.SeleniumhqMainPage;

import java.util.concurrent.TimeUnit;

public class SeleniumhqCase {

    private WebDriver driver;

    @Before
    public void driverSetUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.seleniumhq.org/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void testTableSelenium() throws InterruptedException {
        String langsTextExpected[] = new String[]{"Java", "C#", "Ruby", "Python", "Javascript (Node)"};
        final SeleniumhqMainPage seleniumMain = new SeleniumhqMainPage(driver);
        final DownloadsPage downloadsPage = seleniumMain.clickDownloadTab();
        Thread.sleep(1000);
        downloadsPage.verifyLangsDownloadText(langsTextExpected);

    }

    @After
    public void driverClose() {
        driver.close();
    }

}
