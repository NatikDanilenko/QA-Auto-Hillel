package pageobjectWikipedia;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {

    @FindBy(xpath = "//h1[@id = 'firstHeading']")
    private WebElement firstHeading;

    public SearchResultPage (final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean verifyLabel (String label) {
        if (firstHeading.getText().contentEquals(label))
        return true;
        else return false;
    }

}
