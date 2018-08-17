package pageobjectsRozetka;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchResult1stPageTabletsSamsung {


    private WebDriver driver;
    private WebDriverWait webDriverWait;

    @FindBy(xpath = "//li[@id = 'filter_producer_12']")
    private WebElement filterSamsungCheckbox;

    @FindBys(
            @FindBy(xpath = "//div[contains(@class, 'touch')]")
    )
    private List<WebElement> searchResultTabletsSamsung;


    public SearchResult1stPageTabletsSamsung(final WebDriver driver) {
        webDriverWait = new WebDriverWait(driver, 30);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void verifyFilterFunctionality() {

        webDriverWait.until(ExpectedConditions.elementToBeClickable(filterSamsungCheckbox));
        webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[contains(@class, 'touch')]")));
        for (final WebElement filterResultItem : searchResultTabletsSamsung) {
            final String text = filterResultItem.getText().toUpperCase();
            System.out.println(text);
            Assert.assertTrue("Filter doesn't work!", text.contains("SAMSUNG"));
        }

   }
    }

