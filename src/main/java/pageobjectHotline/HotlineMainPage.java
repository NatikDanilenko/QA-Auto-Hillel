package pageobjectHotline;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HotlineMainPage {

    private WebDriver driver;

    public HotlineMainPage (final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        }

    public SearchResultPage navigateByPartialLink(final String partialUrl) {
        final String fullUrlToNavigate = String.format("%s%s", driver.getCurrentUrl(), partialUrl);
        driver.get(fullUrlToNavigate);
        return new SearchResultPage (driver);
    }


}
