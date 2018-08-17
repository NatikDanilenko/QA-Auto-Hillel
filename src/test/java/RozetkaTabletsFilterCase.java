import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjectsRozetka.RozetkaMainPage;
import pageobjectsRozetka.SearchResult1stPageTabletsSamsung;
import pageobjectsRozetka.SearchResultPageTablets;
import pageobjectsRozetka.SearchResultPageTabletsFilter;

import java.util.concurrent.TimeUnit;

public class RozetkaTabletsFilterCase {

    private WebDriver driver;

    @Before
    public void driverSetUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rozetka.com.ua/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void verifyFilterTabletsSamsung() throws InterruptedException {
        final RozetkaMainPage rozetkaMainPage = new RozetkaMainPage(driver);
        final RozetkaMainPage rozetkaMainPageMenu = rozetkaMainPage.clickLaptopAndComputers();
        final SearchResultPageTablets pageTablets = rozetkaMainPageMenu.clickOptionTablets();
        final SearchResultPageTabletsFilter pageTabletsFilter = pageTablets.clickAllTablets();
        final SearchResult1stPageTabletsSamsung pageTabletsSamsung = pageTabletsFilter.clickFilterSamsung();
        pageTabletsSamsung.verifyFilterFunctionality();
    }

     @After
     public void driverClose() {
     driver.close();
    }

    }



