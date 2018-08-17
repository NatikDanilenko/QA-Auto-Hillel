package pageobjectsRozetka;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchResultPageTabletsFilter {

    private WebDriver driver;

    @FindBys(
            @FindBy(xpath = "//div[@class = 'g-i-tile g-i-tile-catalog touch']")
    )
    private List<WebElement> searchResultsTables;

    @FindBy(xpath = "//li[@id = 'filter_producer_12']")
    private WebElement filterSamsungCheckbox;



    public SearchResultPageTabletsFilter (final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public SearchResult1stPageTabletsSamsung clickFilterSamsung() {
        filterSamsungCheckbox.click();
        return new SearchResult1stPageTabletsSamsung(driver);
    }

}

