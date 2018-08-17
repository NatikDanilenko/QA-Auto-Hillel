package pageobjectsRozetka;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPageTablets {

    private WebDriver driver;

    @FindBy(xpath = "//a[@class = 'pab-group-href-link arrow-link']//span[text() = 'Все планшеты']")
    private WebElement allTablets;



    public SearchResultPageTablets (final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public SearchResultPageTabletsFilter clickAllTablets() {
        allTablets.click();
        return new SearchResultPageTabletsFilter(driver);
    }





}
