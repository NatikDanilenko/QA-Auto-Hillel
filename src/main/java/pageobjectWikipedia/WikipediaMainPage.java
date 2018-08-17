package pageobjectWikipedia;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikipediaMainPage {


    @FindBy(xpath = "//input[@id='searchInput']")
    private WebElement searchInput;

    @FindBy (xpath = "//input[@id='searchButton']")
    private WebElement searchButton;

    private WebDriver driver;

    public WikipediaMainPage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void typeSearchedText(final String textToSearch) {
        searchInput.sendKeys(textToSearch);
    }

    public SearchResultPage clickSearchButton() {
        searchButton.click();
        return new SearchResultPage(driver);
    }

}
