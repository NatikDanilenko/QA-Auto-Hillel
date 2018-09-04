import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjectHotline.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HotlineTestSuite {

    private WebDriver driver;

    private static final String SEARCH_RESULT_PARTIAL_LINK = "mobile/mobilnye-telefony-i-smartfony/";

    @Before
    public void driverSetUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://hotline.ua/");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void verifyComparisonListEmpty()  {

        final String firstItem = "Samsung Galaxy Note9 6/128GB Ocean Blue (SM-N960FZBD)";
        final String secondItem = "Samsung Galaxy S8 64GB Black (SM-G950FZKD)";
        final HotlineMainPage mainPage = new HotlineMainPage(driver);
        final SearchResultPage searchResultPageMobile = mainPage.navigateByPartialLink
                (SEARCH_RESULT_PARTIAL_LINK);
        final FilterResultPage filterResultPage = searchResultPageMobile.clickFilterSamsung();


        final List<String> itemsToCompare = new ArrayList<String>();
        itemsToCompare.add(firstItem);
        itemsToCompare.add(secondItem);
        filterResultPage.addToComparisonList(itemsToCompare);
        final ComparisonListPage comparisonListPage = filterResultPage.goToComparisonList();

        final String expectedItemsList [] = new String[]{firstItem, secondItem};
        comparisonListPage.getTextSelectedItems(expectedItemsList);
        Arrays.sort(expectedItemsList);
        Arrays.sort(itemsToCompare.toArray());

        Assert.assertArrayEquals("The items do not match the selected ones!", expectedItemsList,
                itemsToCompare.toArray());

        comparisonListPage.deleteSelectedItems();

        final String popupTextExpected = "Ваш список \"Сравнения\" пуст.";
        final String popupText = filterResultPage.getTextComparisonListEmpty();

        Assert.assertTrue("The text is incorrect", popupText.contains(popupTextExpected));
    }

    @Test
    public void verifyMaxAndMinPricesForItem() {

        final String item = "Xiaomi Redmi Note 5 4/64GB Black";
        final HotlineMainPage mainPage = new HotlineMainPage(driver);
        final SearchResultPage searchResultPageMobile = mainPage.navigateByPartialLink
                (SEARCH_RESULT_PARTIAL_LINK);
        final ItemPriceRangePage itemPriceRangePage = searchResultPageMobile.clickComparePricesButton(item);
        itemPriceRangePage.findAndVerifyMinAndMaxPrices();
    }

     @After
    public void driverTeamDown() {
        driver.close();
    }
}

